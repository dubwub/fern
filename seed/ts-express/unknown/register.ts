/**
 * This file was auto-generated by Fern from our API Definition.
 */

import express from "express";
import { UnknownService } from "./api/resources/unknown/service/UnknownService";

export function register(
    expressApp: express.Express | express.Router,
    services: {
        unknown: UnknownService;
    }
): void {
    (expressApp as any).use("/", services.unknown.toRouter());
}
