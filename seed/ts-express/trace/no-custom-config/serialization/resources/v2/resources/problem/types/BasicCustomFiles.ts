/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../../../index";
import * as SeedTrace from "../../../../../../api/index";
import * as core from "../../../../../../core";

export const BasicCustomFiles: core.serialization.ObjectSchema<
    serializers.v2.BasicCustomFiles.Raw,
    SeedTrace.v2.BasicCustomFiles
> = core.serialization.object({
    methodName: core.serialization.string(),
    signature: core.serialization.lazyObject(async () => (await import("../../../../..")).v2.NonVoidFunctionSignature),
    additionalFiles: core.serialization.record(
        core.serialization.lazy(async () => (await import("../../../../..")).Language),
        core.serialization.lazyObject(async () => (await import("../../../../..")).v2.Files).optional()
    ),
    basicTestCaseTemplate: core.serialization.lazyObject(
        async () => (await import("../../../../..")).v2.BasicTestCaseTemplate
    ),
});

export declare namespace BasicCustomFiles {
    interface Raw {
        methodName: string;
        signature: serializers.v2.NonVoidFunctionSignature.Raw;
        additionalFiles: Record<serializers.Language.Raw, serializers.v2.Files.Raw | null | undefined>;
        basicTestCaseTemplate: serializers.v2.BasicTestCaseTemplate.Raw;
    }
}
