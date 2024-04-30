/**
 * This file was auto-generated by Fern from our API Definition.
 */

import express from "express";
import * as SeedExhaustive from "../../../../../index";
import * as serializers from "../../../../../../serialization/index";
import * as errors from "../../../../../../errors/index";

export interface ContainerServiceMethods {
    getAndReturnListOfPrimitives(
        req: express.Request<never, string[], string[], never>,
        res: {
            send: (responseBody: string[]) => Promise<void>;
            cookie: (cookie: string, value: string, options?: express.CookieOptions) => void;
            locals: any;
        }
    ): void | Promise<void>;
    getAndReturnListOfObjects(
        req: express.Request<
            never,
            SeedExhaustive.types.ObjectWithRequiredField[],
            SeedExhaustive.types.ObjectWithRequiredField[],
            never
        >,
        res: {
            send: (responseBody: SeedExhaustive.types.ObjectWithRequiredField[]) => Promise<void>;
            cookie: (cookie: string, value: string, options?: express.CookieOptions) => void;
            locals: any;
        }
    ): void | Promise<void>;
    getAndReturnSetOfPrimitives(
        req: express.Request<never, Set<string>, Set<string>, never>,
        res: {
            send: (responseBody: Set<string>) => Promise<void>;
            cookie: (cookie: string, value: string, options?: express.CookieOptions) => void;
            locals: any;
        }
    ): void | Promise<void>;
    getAndReturnSetOfObjects(
        req: express.Request<
            never,
            SeedExhaustive.types.ObjectWithRequiredField[],
            SeedExhaustive.types.ObjectWithRequiredField[],
            never
        >,
        res: {
            send: (responseBody: SeedExhaustive.types.ObjectWithRequiredField[]) => Promise<void>;
            cookie: (cookie: string, value: string, options?: express.CookieOptions) => void;
            locals: any;
        }
    ): void | Promise<void>;
    getAndReturnMapPrimToPrim(
        req: express.Request<never, Record<string, string>, Record<string, string>, never>,
        res: {
            send: (responseBody: Record<string, string>) => Promise<void>;
            cookie: (cookie: string, value: string, options?: express.CookieOptions) => void;
            locals: any;
        }
    ): void | Promise<void>;
    getAndReturnMapOfPrimToObject(
        req: express.Request<
            never,
            Record<string, SeedExhaustive.types.ObjectWithRequiredField>,
            Record<string, SeedExhaustive.types.ObjectWithRequiredField>,
            never
        >,
        res: {
            send: (responseBody: Record<string, SeedExhaustive.types.ObjectWithRequiredField>) => Promise<void>;
            cookie: (cookie: string, value: string, options?: express.CookieOptions) => void;
            locals: any;
        }
    ): void | Promise<void>;
    getAndReturnOptional(
        req: express.Request<
            never,
            SeedExhaustive.types.ObjectWithRequiredField | undefined,
            SeedExhaustive.types.ObjectWithRequiredField | undefined,
            never
        >,
        res: {
            send: (responseBody: SeedExhaustive.types.ObjectWithRequiredField | undefined) => Promise<void>;
            cookie: (cookie: string, value: string, options?: express.CookieOptions) => void;
            locals: any;
        }
    ): void | Promise<void>;
}

export class ContainerService {
    private router;

    constructor(private readonly methods: ContainerServiceMethods, middleware: express.RequestHandler[] = []) {
        this.router = express.Router({ mergeParams: true }).use(
            express.json({
                strict: false,
            }),
            ...middleware
        );
    }

    public addMiddleware(handler: express.RequestHandler): this {
        this.router.use(handler);
        return this;
    }

    public toRouter(): express.Router {
        this.router.post("/list-of-primitives", async (req, res, next) => {
            const request = await serializers.endpoints.container.getAndReturnListOfPrimitives.Request.parse(req.body);
            if (request.ok) {
                req.body = request.value;
                try {
                    await this.methods.getAndReturnListOfPrimitives(req as any, {
                        send: async (responseBody) => {
                            res.json(
                                await serializers.endpoints.container.getAndReturnListOfPrimitives.Response.jsonOrThrow(
                                    responseBody,
                                    {
                                        unrecognizedObjectKeys: "passthrough",
                                        allowUnrecognizedUnionMembers: true,
                                        allowUnrecognizedEnumValues: true,
                                    }
                                )
                            );
                        },
                        cookie: res.cookie.bind(res),
                        locals: res.locals,
                    });
                    next();
                } catch (error) {
                    console.error(error);
                    if (error instanceof errors.SeedExhaustiveError) {
                        console.warn(
                            `Endpoint 'getAndReturnListOfPrimitives' unexpectedly threw ${error.constructor.name}.` +
                                ` If this was intentional, please add ${error.constructor.name} to` +
                                " the endpoint's errors list in your Fern Definition."
                        );
                        await error.send(res);
                    } else {
                        res.status(500).json("Internal Server Error");
                    }
                    next(error);
                }
            } else {
                res.status(422).json({
                    errors: request.errors.map(
                        (error) => ["request", ...error.path].join(" -> ") + ": " + error.message
                    ),
                });
                next(request.errors);
            }
        });
        this.router.post("/list-of-objects", async (req, res, next) => {
            const request = await serializers.endpoints.container.getAndReturnListOfObjects.Request.parse(req.body);
            if (request.ok) {
                req.body = request.value;
                try {
                    await this.methods.getAndReturnListOfObjects(req as any, {
                        send: async (responseBody) => {
                            res.json(
                                await serializers.endpoints.container.getAndReturnListOfObjects.Response.jsonOrThrow(
                                    responseBody,
                                    {
                                        unrecognizedObjectKeys: "passthrough",
                                        allowUnrecognizedUnionMembers: true,
                                        allowUnrecognizedEnumValues: true,
                                    }
                                )
                            );
                        },
                        cookie: res.cookie.bind(res),
                        locals: res.locals,
                    });
                    next();
                } catch (error) {
                    console.error(error);
                    if (error instanceof errors.SeedExhaustiveError) {
                        console.warn(
                            `Endpoint 'getAndReturnListOfObjects' unexpectedly threw ${error.constructor.name}.` +
                                ` If this was intentional, please add ${error.constructor.name} to` +
                                " the endpoint's errors list in your Fern Definition."
                        );
                        await error.send(res);
                    } else {
                        res.status(500).json("Internal Server Error");
                    }
                    next(error);
                }
            } else {
                res.status(422).json({
                    errors: request.errors.map(
                        (error) => ["request", ...error.path].join(" -> ") + ": " + error.message
                    ),
                });
                next(request.errors);
            }
        });
        this.router.post("/set-of-primitives", async (req, res, next) => {
            const request = await serializers.endpoints.container.getAndReturnSetOfPrimitives.Request.parse(req.body);
            if (request.ok) {
                req.body = request.value;
                try {
                    await this.methods.getAndReturnSetOfPrimitives(req as any, {
                        send: async (responseBody) => {
                            res.json(
                                await serializers.endpoints.container.getAndReturnSetOfPrimitives.Response.jsonOrThrow(
                                    responseBody,
                                    {
                                        unrecognizedObjectKeys: "passthrough",
                                        allowUnrecognizedUnionMembers: true,
                                        allowUnrecognizedEnumValues: true,
                                    }
                                )
                            );
                        },
                        cookie: res.cookie.bind(res),
                        locals: res.locals,
                    });
                    next();
                } catch (error) {
                    console.error(error);
                    if (error instanceof errors.SeedExhaustiveError) {
                        console.warn(
                            `Endpoint 'getAndReturnSetOfPrimitives' unexpectedly threw ${error.constructor.name}.` +
                                ` If this was intentional, please add ${error.constructor.name} to` +
                                " the endpoint's errors list in your Fern Definition."
                        );
                        await error.send(res);
                    } else {
                        res.status(500).json("Internal Server Error");
                    }
                    next(error);
                }
            } else {
                res.status(422).json({
                    errors: request.errors.map(
                        (error) => ["request", ...error.path].join(" -> ") + ": " + error.message
                    ),
                });
                next(request.errors);
            }
        });
        this.router.post("/set-of-objects", async (req, res, next) => {
            const request = await serializers.endpoints.container.getAndReturnSetOfObjects.Request.parse(req.body);
            if (request.ok) {
                req.body = request.value;
                try {
                    await this.methods.getAndReturnSetOfObjects(req as any, {
                        send: async (responseBody) => {
                            res.json(
                                await serializers.endpoints.container.getAndReturnSetOfObjects.Response.jsonOrThrow(
                                    responseBody,
                                    {
                                        unrecognizedObjectKeys: "passthrough",
                                        allowUnrecognizedUnionMembers: true,
                                        allowUnrecognizedEnumValues: true,
                                    }
                                )
                            );
                        },
                        cookie: res.cookie.bind(res),
                        locals: res.locals,
                    });
                    next();
                } catch (error) {
                    console.error(error);
                    if (error instanceof errors.SeedExhaustiveError) {
                        console.warn(
                            `Endpoint 'getAndReturnSetOfObjects' unexpectedly threw ${error.constructor.name}.` +
                                ` If this was intentional, please add ${error.constructor.name} to` +
                                " the endpoint's errors list in your Fern Definition."
                        );
                        await error.send(res);
                    } else {
                        res.status(500).json("Internal Server Error");
                    }
                    next(error);
                }
            } else {
                res.status(422).json({
                    errors: request.errors.map(
                        (error) => ["request", ...error.path].join(" -> ") + ": " + error.message
                    ),
                });
                next(request.errors);
            }
        });
        this.router.post("/map-prim-to-prim", async (req, res, next) => {
            const request = await serializers.endpoints.container.getAndReturnMapPrimToPrim.Request.parse(req.body);
            if (request.ok) {
                req.body = request.value;
                try {
                    await this.methods.getAndReturnMapPrimToPrim(req as any, {
                        send: async (responseBody) => {
                            res.json(
                                await serializers.endpoints.container.getAndReturnMapPrimToPrim.Response.jsonOrThrow(
                                    responseBody,
                                    {
                                        unrecognizedObjectKeys: "passthrough",
                                        allowUnrecognizedUnionMembers: true,
                                        allowUnrecognizedEnumValues: true,
                                    }
                                )
                            );
                        },
                        cookie: res.cookie.bind(res),
                        locals: res.locals,
                    });
                    next();
                } catch (error) {
                    console.error(error);
                    if (error instanceof errors.SeedExhaustiveError) {
                        console.warn(
                            `Endpoint 'getAndReturnMapPrimToPrim' unexpectedly threw ${error.constructor.name}.` +
                                ` If this was intentional, please add ${error.constructor.name} to` +
                                " the endpoint's errors list in your Fern Definition."
                        );
                        await error.send(res);
                    } else {
                        res.status(500).json("Internal Server Error");
                    }
                    next(error);
                }
            } else {
                res.status(422).json({
                    errors: request.errors.map(
                        (error) => ["request", ...error.path].join(" -> ") + ": " + error.message
                    ),
                });
                next(request.errors);
            }
        });
        this.router.post("/map-prim-to-object", async (req, res, next) => {
            const request = await serializers.endpoints.container.getAndReturnMapOfPrimToObject.Request.parse(req.body);
            if (request.ok) {
                req.body = request.value;
                try {
                    await this.methods.getAndReturnMapOfPrimToObject(req as any, {
                        send: async (responseBody) => {
                            res.json(
                                await serializers.endpoints.container.getAndReturnMapOfPrimToObject.Response.jsonOrThrow(
                                    responseBody,
                                    {
                                        unrecognizedObjectKeys: "passthrough",
                                        allowUnrecognizedUnionMembers: true,
                                        allowUnrecognizedEnumValues: true,
                                    }
                                )
                            );
                        },
                        cookie: res.cookie.bind(res),
                        locals: res.locals,
                    });
                    next();
                } catch (error) {
                    console.error(error);
                    if (error instanceof errors.SeedExhaustiveError) {
                        console.warn(
                            `Endpoint 'getAndReturnMapOfPrimToObject' unexpectedly threw ${error.constructor.name}.` +
                                ` If this was intentional, please add ${error.constructor.name} to` +
                                " the endpoint's errors list in your Fern Definition."
                        );
                        await error.send(res);
                    } else {
                        res.status(500).json("Internal Server Error");
                    }
                    next(error);
                }
            } else {
                res.status(422).json({
                    errors: request.errors.map(
                        (error) => ["request", ...error.path].join(" -> ") + ": " + error.message
                    ),
                });
                next(request.errors);
            }
        });
        this.router.post("/opt-objects", async (req, res, next) => {
            const request = await serializers.endpoints.container.getAndReturnOptional.Request.parse(req.body);
            if (request.ok) {
                req.body = request.value;
                try {
                    await this.methods.getAndReturnOptional(req as any, {
                        send: async (responseBody) => {
                            res.json(
                                await serializers.endpoints.container.getAndReturnOptional.Response.jsonOrThrow(
                                    responseBody,
                                    {
                                        unrecognizedObjectKeys: "passthrough",
                                        allowUnrecognizedUnionMembers: true,
                                        allowUnrecognizedEnumValues: true,
                                    }
                                )
                            );
                        },
                        cookie: res.cookie.bind(res),
                        locals: res.locals,
                    });
                    next();
                } catch (error) {
                    console.error(error);
                    if (error instanceof errors.SeedExhaustiveError) {
                        console.warn(
                            `Endpoint 'getAndReturnOptional' unexpectedly threw ${error.constructor.name}.` +
                                ` If this was intentional, please add ${error.constructor.name} to` +
                                " the endpoint's errors list in your Fern Definition."
                        );
                        await error.send(res);
                    } else {
                        res.status(500).json("Internal Server Error");
                    }
                    next(error);
                }
            } else {
                res.status(422).json({
                    errors: request.errors.map(
                        (error) => ["request", ...error.path].join(" -> ") + ": " + error.message
                    ),
                });
                next(request.errors);
            }
        });
        return this.router;
    }
}
