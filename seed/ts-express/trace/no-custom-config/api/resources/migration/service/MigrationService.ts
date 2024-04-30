/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as SeedTrace from "../../../index";
import express from "express";
import * as serializers from "../../../../serialization/index";
import * as errors from "../../../../errors/index";

export interface MigrationServiceMethods {
    getAttemptedMigrations(
        req: express.Request<never, SeedTrace.Migration[], never, never>,
        res: {
            send: (responseBody: SeedTrace.Migration[]) => Promise<void>;
            cookie: (cookie: string, value: string, options?: express.CookieOptions) => void;
            locals: any;
        }
    ): void | Promise<void>;
}

export class MigrationService {
    private router;

    constructor(private readonly methods: MigrationServiceMethods, middleware: express.RequestHandler[] = []) {
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
        this.router.get("/all", async (req, res, next) => {
            try {
                await this.methods.getAttemptedMigrations(req as any, {
                    send: async (responseBody) => {
                        res.json(
                            await serializers.migration.getAttemptedMigrations.Response.jsonOrThrow(responseBody, {
                                unrecognizedObjectKeys: "strip",
                            })
                        );
                    },
                    cookie: res.cookie.bind(res),
                    locals: res.locals,
                });
                next();
            } catch (error) {
                console.error(error);
                if (error instanceof errors.SeedTraceError) {
                    console.warn(
                        `Endpoint 'getAttemptedMigrations' unexpectedly threw ${error.constructor.name}.` +
                            ` If this was intentional, please add ${error.constructor.name} to` +
                            " the endpoint's errors list in your Fern Definition."
                    );
                    await error.send(res);
                } else {
                    res.status(500).json("Internal Server Error");
                }
                next(error);
            }
        });
        return this.router;
    }
}
