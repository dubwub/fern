/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as SeedTrace from "../../../index";
import express from "express";
import * as errors from "../../../../errors/index";

export interface PlaylistServiceMethods {
    createPlaylist(
        req: express.Request<
            {
                serviceParam: number;
            },
            SeedTrace.Playlist,
            SeedTrace.PlaylistCreateRequest,
            {
                datetime: string;
                optionalDatetime?: string;
            }
        >,
        res: {
            send: (responseBody: SeedTrace.Playlist) => Promise<void>;
            cookie: (cookie: string, value: string, options?: express.CookieOptions) => void;
            locals: any;
        }
    ): void | Promise<void>;
    getPlaylists(
        req: express.Request<
            {
                serviceParam: number;
            },
            SeedTrace.Playlist[],
            never,
            {
                limit?: number;
                otherField: string;
                multiLineDocs: string;
                optionalMultipleField?: string;
                multipleField: string;
            }
        >,
        res: {
            send: (responseBody: SeedTrace.Playlist[]) => Promise<void>;
            cookie: (cookie: string, value: string, options?: express.CookieOptions) => void;
            locals: any;
        }
    ): void | Promise<void>;
    getPlaylist(
        req: express.Request<
            {
                serviceParam: number;
                playlistId: SeedTrace.PlaylistId;
            },
            SeedTrace.Playlist,
            never,
            never
        >,
        res: {
            send: (responseBody: SeedTrace.Playlist) => Promise<void>;
            cookie: (cookie: string, value: string, options?: express.CookieOptions) => void;
            locals: any;
        }
    ): void | Promise<void>;
    updatePlaylist(
        req: express.Request<
            {
                serviceParam: number;
                playlistId: SeedTrace.PlaylistId;
            },
            SeedTrace.Playlist | undefined,
            SeedTrace.UpdatePlaylistRequest | undefined,
            never
        >,
        res: {
            send: (responseBody: SeedTrace.Playlist | undefined) => Promise<void>;
            cookie: (cookie: string, value: string, options?: express.CookieOptions) => void;
            locals: any;
        }
    ): void | Promise<void>;
    deletePlaylist(
        req: express.Request<
            {
                serviceParam: number;
                playlist_id: SeedTrace.PlaylistId;
            },
            never,
            never,
            never
        >,
        res: {
            send: () => Promise<void>;
            cookie: (cookie: string, value: string, options?: express.CookieOptions) => void;
            locals: any;
        }
    ): void | Promise<void>;
}

export class PlaylistService {
    private router;

    constructor(private readonly methods: PlaylistServiceMethods, middleware: express.RequestHandler[] = []) {
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
        this.router.post("/create", async (req, res, next) => {
            try {
                await this.methods.createPlaylist(req as any, {
                    send: async (responseBody) => {
                        res.json(responseBody);
                    },
                    cookie: res.cookie.bind(res),
                    locals: res.locals,
                });
                next();
            } catch (error) {
                console.error(error);
                if (error instanceof errors.SeedTraceError) {
                    console.warn(
                        `Endpoint 'createPlaylist' unexpectedly threw ${error.constructor.name}.` +
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
        this.router.get("/all", async (req, res, next) => {
            try {
                await this.methods.getPlaylists(req as any, {
                    send: async (responseBody) => {
                        res.json(responseBody);
                    },
                    cookie: res.cookie.bind(res),
                    locals: res.locals,
                });
                next();
            } catch (error) {
                console.error(error);
                if (error instanceof errors.SeedTraceError) {
                    console.warn(
                        `Endpoint 'getPlaylists' unexpectedly threw ${error.constructor.name}.` +
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
        this.router.get("/:playlistId", async (req, res, next) => {
            try {
                await this.methods.getPlaylist(req as any, {
                    send: async (responseBody) => {
                        res.json(responseBody);
                    },
                    cookie: res.cookie.bind(res),
                    locals: res.locals,
                });
                next();
            } catch (error) {
                console.error(error);
                if (error instanceof errors.SeedTraceError) {
                    switch (error.errorName) {
                        case "PlaylistIdNotFoundError":
                        case "UnauthorizedError":
                            break;
                        default:
                            console.warn(
                                `Endpoint 'getPlaylist' unexpectedly threw ${error.constructor.name}.` +
                                    ` If this was intentional, please add ${error.constructor.name} to` +
                                    " the endpoint's errors list in your Fern Definition."
                            );
                    }
                    await error.send(res);
                } else {
                    res.status(500).json("Internal Server Error");
                }
                next(error);
            }
        });
        this.router.put("/:playlistId", async (req, res, next) => {
            try {
                await this.methods.updatePlaylist(req as any, {
                    send: async (responseBody) => {
                        res.json(responseBody);
                    },
                    cookie: res.cookie.bind(res),
                    locals: res.locals,
                });
                next();
            } catch (error) {
                console.error(error);
                if (error instanceof errors.SeedTraceError) {
                    switch (error.errorName) {
                        case "PlaylistIdNotFoundError":
                            break;
                        default:
                            console.warn(
                                `Endpoint 'updatePlaylist' unexpectedly threw ${error.constructor.name}.` +
                                    ` If this was intentional, please add ${error.constructor.name} to` +
                                    " the endpoint's errors list in your Fern Definition."
                            );
                    }
                    await error.send(res);
                } else {
                    res.status(500).json("Internal Server Error");
                }
                next(error);
            }
        });
        this.router.delete("/:playlist_id", async (req, res, next) => {
            try {
                await this.methods.deletePlaylist(req as any, {
                    send: async () => {
                        res.sendStatus(204);
                    },
                    cookie: res.cookie.bind(res),
                    locals: res.locals,
                });
                next();
            } catch (error) {
                console.error(error);
                if (error instanceof errors.SeedTraceError) {
                    console.warn(
                        `Endpoint 'deletePlaylist' unexpectedly threw ${error.constructor.name}.` +
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
