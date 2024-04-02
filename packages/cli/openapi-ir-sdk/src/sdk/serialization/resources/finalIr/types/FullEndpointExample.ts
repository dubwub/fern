/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../..";
import * as FernOpenapiIr from "../../../../api";
import * as core from "../../../../core";

export const FullEndpointExample: core.serialization.ObjectSchema<
    serializers.FullEndpointExample.Raw,
    FernOpenapiIr.FullEndpointExample
> = core.serialization
    .objectWithoutOptionalProperties({
        name: core.serialization.string().optional(),
        pathParameters: core.serialization
            .list(core.serialization.lazyObject(async () => (await import("../../..")).PathParameterExample))
            .optional(),
        queryParameters: core.serialization
            .list(core.serialization.lazyObject(async () => (await import("../../..")).QueryParameterExample))
            .optional(),
        headers: core.serialization
            .list(core.serialization.lazyObject(async () => (await import("../../..")).HeaderExample))
            .optional(),
        request: core.serialization.lazy(async () => (await import("../../..")).FullExample).optional(),
        response: core.serialization.lazy(async () => (await import("../../..")).FullExample).optional(),
        codeSamples: core.serialization.list(
            core.serialization.lazy(async () => (await import("../../..")).CustomCodeSample)
        ),
    })
    .extend(core.serialization.lazyObject(async () => (await import("../../..")).WithDescription));

export declare namespace FullEndpointExample {
    interface Raw extends serializers.WithDescription.Raw {
        name?: string | null;
        pathParameters?: serializers.PathParameterExample.Raw[] | null;
        queryParameters?: serializers.QueryParameterExample.Raw[] | null;
        headers?: serializers.HeaderExample.Raw[] | null;
        request?: serializers.FullExample.Raw | null;
        response?: serializers.FullExample.Raw | null;
        codeSamples: serializers.CustomCodeSample.Raw[];
    }
}
