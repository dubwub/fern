import {
    HttpEndpoint,
    HttpHeader,
    HttpRequestBody,
    HttpService,
    InlinedRequestBodyProperty,
    QueryParameter,
} from "@fern-fern/ir-model/http";
import { TypeReference } from "@fern-fern/ir-model/types";
import { getTextOfTsNode, maybeAddDocs } from "@fern-typescript/commons";
import { GeneratedRequestWrapper, RequestWrapperContext } from "@fern-typescript/contexts";
import { ts } from "ts-morph";

export declare namespace GeneratedRequestWrapperImpl {
    export interface Init {
        service: HttpService;
        endpoint: HttpEndpoint;
        wrapperName: string;
    }
}

export class GeneratedRequestWrapperImpl implements GeneratedRequestWrapper {
    // this has an underscore to prevent deconflicting with user-provided names
    // that are in scope (e.g. path parameters)
    private static QUERY_PARAM_LIST_ITEM = "_item";

    private service: HttpService;
    private endpoint: HttpEndpoint;
    private wrapperName: string;

    constructor({ service, endpoint, wrapperName }: GeneratedRequestWrapperImpl.Init) {
        this.service = service;
        this.endpoint = endpoint;
        this.wrapperName = wrapperName;
    }

    public writeToFile(context: RequestWrapperContext): void {
        const requestInterface = context.base.sourceFile.addInterface({
            name: this.wrapperName,
            isExported: true,
        });
        for (const queryParameter of this.getAllQueryParameters()) {
            const type = context.type.getReferenceToType(queryParameter.valueType);
            const property = requestInterface.addProperty({
                name: this.getPropertyNameOfQueryParameter(queryParameter),
                type: getTextOfTsNode(
                    queryParameter.allowMultiple
                        ? ts.factory.createUnionTypeNode([
                              type.typeNodeWithoutUndefined,
                              ts.factory.createArrayTypeNode(type.typeNodeWithoutUndefined),
                          ])
                        : type.typeNodeWithoutUndefined
                ),
                hasQuestionToken: type.isOptional,
            });
            maybeAddDocs(property, queryParameter.docs);
        }
        for (const header of this.getAllHeaders()) {
            const type = context.type.getReferenceToType(header.valueType);
            const property = requestInterface.addProperty({
                name: this.getPropertyNameOfHeader(header),
                type: getTextOfTsNode(type.typeNodeWithoutUndefined),
                hasQuestionToken: type.isOptional,
            });
            maybeAddDocs(property, header.docs);
        }
        if (this.endpoint.requestBody != null) {
            HttpRequestBody._visit(this.endpoint.requestBody, {
                inlinedRequestBody: (inlinedRequestBody) => {
                    for (const property of inlinedRequestBody.properties) {
                        const type = context.type.getReferenceToType(property.valueType);
                        requestInterface.addProperty({
                            name: this.getInlinedRequestBodyPropertyKey(property),
                            type: getTextOfTsNode(type.typeNodeWithoutUndefined),
                            hasQuestionToken: type.isOptional,
                        });
                    }
                    for (const extension of inlinedRequestBody.extends) {
                        requestInterface.addExtends(
                            getTextOfTsNode(context.type.getReferenceToNamedType(extension).getTypeNode())
                        );
                    }
                },
                reference: (referenceToRequestBody) => {
                    const type = context.type.getReferenceToType(referenceToRequestBody.requestBodyType);
                    const property = requestInterface.addProperty({
                        name: this.getReferencedBodyPropertyName(),
                        type: getTextOfTsNode(type.typeNodeWithoutUndefined),
                        hasQuestionToken: type.isOptional,
                    });
                    maybeAddDocs(property, referenceToRequestBody.docs);
                },
                _unknown: () => {
                    throw new Error("Unknown HttpRequestBody: " + this.endpoint.requestBody?.type);
                },
            });
        }
    }

    public withQueryParameter({
        queryParameter,
        requestArgument,
        isRequestArgumentNullable,
        context,
        callback,
    }: {
        queryParameter: QueryParameter;
        requestArgument: ts.Expression;
        isRequestArgumentNullable: boolean;
        context: RequestWrapperContext;
        callback: (value: ts.Expression) => ts.Statement[];
    }): ts.Statement[] {
        let statements: ts.Statement[];

        const requestPropertyForQueryParam = this.accessRequestProperty({
            requestArgument,
            isRequestArgumentNullable,
            key: this.getPropertyNameOfQueryParameter(queryParameter),
        });

        if (queryParameter.allowMultiple) {
            statements = [
                ts.factory.createIfStatement(
                    ts.factory.createCallExpression(
                        ts.factory.createPropertyAccessExpression(
                            ts.factory.createIdentifier("Array"),
                            ts.factory.createIdentifier("isArray")
                        ),
                        undefined,
                        [requestPropertyForQueryParam]
                    ),
                    ts.factory.createBlock(
                        [
                            ts.factory.createForOfStatement(
                                undefined,
                                ts.factory.createVariableDeclarationList(
                                    [
                                        ts.factory.createVariableDeclaration(
                                            GeneratedRequestWrapperImpl.QUERY_PARAM_LIST_ITEM
                                        ),
                                    ],
                                    ts.NodeFlags.Const
                                ),
                                requestPropertyForQueryParam,
                                ts.factory.createBlock(
                                    callback(
                                        ts.factory.createIdentifier(GeneratedRequestWrapperImpl.QUERY_PARAM_LIST_ITEM)
                                    ),
                                    true
                                )
                            ),
                        ],
                        true
                    ),
                    ts.factory.createBlock(callback(requestPropertyForQueryParam), true)
                ),
            ];
        } else {
            statements = callback(requestPropertyForQueryParam);
        }

        const resolvedType = context.type.resolveTypeReference(queryParameter.valueType);
        const isQueryParamOptional = resolvedType._type === "container" && resolvedType.container._type === "optional";
        if (isRequestArgumentNullable || isQueryParamOptional) {
            statements = [
                ts.factory.createIfStatement(
                    ts.factory.createBinaryExpression(
                        requestPropertyForQueryParam,
                        ts.factory.createToken(ts.SyntaxKind.ExclamationEqualsToken),
                        ts.factory.createNull()
                    ),
                    ts.factory.createBlock(statements)
                ),
            ];
        }

        return statements;
    }

    public getReferenceToHeader({
        header,
        requestArgument,
        isRequestArgumentNullable,
    }: {
        header: HttpHeader;
        requestArgument: ts.Expression;
        isRequestArgumentNullable: boolean;
    }): ts.Expression {
        return this.accessRequestProperty({
            requestArgument,
            isRequestArgumentNullable,
            key: this.getPropertyNameOfHeader(header),
        });
    }

    public getReferenceToBody({
        requestArgument,
        isRequestArgumentNullable,
        context,
    }: {
        requestArgument: ts.Expression;
        isRequestArgumentNullable: boolean;
        context: RequestWrapperContext;
    }): ts.Expression | undefined {
        if (this.endpoint.requestBody == null) {
            return undefined;
        }
        return HttpRequestBody._visit<ts.Expression>(this.endpoint.requestBody, {
            reference: () =>
                this.accessRequestProperty({
                    requestArgument,
                    isRequestArgumentNullable,
                    key: this.getReferencedBodyPropertyName(),
                }),
            inlinedRequestBody: (inlinedRequestBody) => {
                return ts.factory.createObjectLiteralExpression(
                    [
                        ...inlinedRequestBody.properties.map((property) =>
                            ts.factory.createPropertyAssignment(
                                ts.factory.createStringLiteral(this.getInlinedRequestBodyPropertyKey(property)),
                                this.accessRequestProperty({
                                    requestArgument,
                                    isRequestArgumentNullable,
                                    key: this.getInlinedRequestBodyPropertyKey(property),
                                })
                            )
                        ),
                        ...inlinedRequestBody.extends.flatMap((extension) => {
                            const generatedType = context.type.getGeneratedType(extension);
                            if (generatedType.type !== "object") {
                                throw new Error("Inlined request extends a non-object");
                            }
                            return generatedType.getAllPropertiesIncludingExtensions(context).map(({ propertyKey }) =>
                                ts.factory.createPropertyAssignment(
                                    ts.factory.createStringLiteral(propertyKey),
                                    this.accessRequestProperty({
                                        requestArgument,
                                        isRequestArgumentNullable,
                                        key: propertyKey,
                                    })
                                )
                            );
                        }),
                    ],
                    true
                );
            },
            _unknown: () => {
                throw new Error("Unknown HttpRequestBody: " + this.endpoint.requestBody?.type);
            },
        });
    }

    #areBodyPropertiesOptional: boolean | undefined;
    public areAllPropertiesOptional(context: RequestWrapperContext): boolean {
        if (this.#areBodyPropertiesOptional == null) {
            this.#areBodyPropertiesOptional = this.expensivelyComputeIfAllPropertiesAreOptional(context);
        }
        return this.#areBodyPropertiesOptional;
    }

    public getNonBodyKeys(): string[] {
        return [
            ...this.getAllQueryParameters().map((queryParameter) =>
                this.getPropertyNameOfQueryParameter(queryParameter)
            ),
            ...this.getAllHeaders().map((header) => this.getPropertyNameOfHeader(header)),
        ];
    }

    public getInlinedRequestBodyPropertyKey(property: InlinedRequestBodyProperty): string {
        return property.name.name.camelCase.unsafeName;
    }

    private expensivelyComputeIfAllPropertiesAreOptional(context: RequestWrapperContext): boolean {
        for (const queryParameter of this.getAllQueryParameters()) {
            if (!this.isTypeOptional(queryParameter.valueType, context)) {
                return false;
            }
        }
        for (const header of this.getAllHeaders()) {
            if (!this.isTypeOptional(header.valueType, context)) {
                return false;
            }
        }
        if (this.endpoint.requestBody != null) {
            const areBodyPropertiesOptional = HttpRequestBody._visit(this.endpoint.requestBody, {
                reference: ({ requestBodyType }) => this.isTypeOptional(requestBodyType, context),
                inlinedRequestBody: (inlinedRequestBody) => {
                    for (const property of inlinedRequestBody.properties) {
                        if (!this.isTypeOptional(property.valueType, context)) {
                            return false;
                        }
                    }
                    for (const extension of inlinedRequestBody.extends) {
                        const generatedType = context.type.getGeneratedType(extension);
                        if (generatedType.type !== "object") {
                            throw new Error("Inlined request extends a non-object");
                        }
                        const propertiesFromExtension = generatedType.getAllPropertiesIncludingExtensions(context);
                        for (const property of propertiesFromExtension) {
                            if (!this.isTypeOptional(property.type, context)) {
                                return false;
                            }
                        }
                    }
                    return true;
                },
                _unknown: () => {
                    throw new Error("Unknown HttpRequestBody: " + this.endpoint.requestBody?.type);
                },
            });
            if (!areBodyPropertiesOptional) {
                return false;
            }
        }
        return true;
    }

    private isTypeOptional(typeReference: TypeReference, context: RequestWrapperContext): boolean {
        const resolvedType = context.type.resolveTypeReference(typeReference);
        return resolvedType._type === "container" && resolvedType.container._type === "optional";
    }

    private getPropertyNameOfQueryParameter(queryParameter: QueryParameter): string {
        return queryParameter.name.name.camelCase.unsafeName;
    }

    private getPropertyNameOfHeader(header: HttpHeader): string {
        return header.name.name.camelCase.unsafeName;
    }

    public getAllQueryParameters(): QueryParameter[] {
        return this.endpoint.queryParameters;
    }

    public getAllHeaders(): HttpHeader[] {
        return [...this.service.headers, ...this.endpoint.headers];
    }

    private getReferencedBodyPropertyName(): string {
        if (this.endpoint.sdkRequest == null) {
            throw new Error("Request body is defined but sdkRequest is null");
        }
        if (this.endpoint.sdkRequest.shape.type !== "wrapper") {
            throw new Error("Request body is defined but sdkRequest is not a wrapper");
        }
        return this.endpoint.sdkRequest.shape.bodyKey.camelCase.unsafeName;
    }

    private accessRequestProperty({
        requestArgument,
        isRequestArgumentNullable,
        key,
    }: {
        requestArgument: ts.Expression;
        isRequestArgumentNullable: boolean;
        key: string;
    }): ts.Expression {
        return ts.factory.createPropertyAccessChain(
            requestArgument,
            isRequestArgumentNullable ? ts.factory.createToken(ts.SyntaxKind.QuestionDotToken) : undefined,
            key
        );
    }
}
