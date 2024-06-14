/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as FernIr from "../../..";

export interface HttpEndpoint extends FernIr.Declaration {
    id: FernIr.EndpointId;
    name: FernIr.EndpointName;
    displayName: string | undefined;
    method: FernIr.HttpMethod;
    headers: FernIr.HttpHeader[];
    baseUrl: FernIr.EnvironmentBaseUrlId | undefined;
    path: FernIr.HttpPath;
    fullPath: FernIr.HttpPath;
    pathParameters: FernIr.PathParameter[];
    allPathParameters: FernIr.PathParameter[];
    queryParameters: FernIr.QueryParameter[];
    requestBody: FernIr.HttpRequestBody | undefined;
    sdkRequest: FernIr.SdkRequest | undefined;
    response: FernIr.HttpResponse | undefined;
    errors: FernIr.ResponseErrors;
    auth: boolean;
    idempotent: boolean;
    pagination: FernIr.Pagination | undefined;
    userSpecifiedExamples: FernIr.UserSpecifiedEndpointExample[];
    autogeneratedExamples: FernIr.AutogeneratedEndpointExample[];
}
