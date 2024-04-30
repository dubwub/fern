/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as core from "../../../../core";
import * as serializers from "../../../index";
import * as SeedMixedCase from "../../../../api/index";

const _Base = core.serialization.object({
    status: core.serialization.lazy(async () => (await import("../../..")).ResourceStatus),
});
export const Resource: core.serialization.Schema<serializers.Resource.Raw, SeedMixedCase.Resource> = core.serialization
    .union(core.serialization.discriminant("resourceType", "resource_type"), {
        user: core.serialization.lazyObject(async () => (await import("../../..")).User).extend(_Base),
        Organization: core.serialization.lazyObject(async () => (await import("../../..")).Organization).extend(_Base),
    })
    .transform<SeedMixedCase.Resource>({
        transform: (value) => value,
        untransform: (value) => value,
    });

export declare namespace Resource {
    type Raw = Resource.User | Resource.Organization;

    interface User extends _Base, serializers.User.Raw {
        resource_type: "user";
    }

    interface Organization extends _Base, serializers.Organization.Raw {
        resource_type: "Organization";
    }

    interface _Base {
        status: serializers.ResourceStatus.Raw;
    }
}
