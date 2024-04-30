/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../index";
import * as SeedTrace from "../../../../api/index";
import * as core from "../../../../core";

export const WorkspaceSubmissionUpdateInfo: core.serialization.Schema<
    serializers.WorkspaceSubmissionUpdateInfo.Raw,
    SeedTrace.WorkspaceSubmissionUpdateInfo
> = core.serialization
    .union("type", {
        running: core.serialization.object({
            value: core.serialization.lazy(async () => (await import("../../..")).RunningSubmissionState),
        }),
        ran: core.serialization.lazyObject(async () => (await import("../../..")).WorkspaceRunDetails),
        stopped: core.serialization.object({}),
        traced: core.serialization.object({}),
        tracedV2: core.serialization.lazyObject(async () => (await import("../../..")).WorkspaceTracedUpdate),
        errored: core.serialization.object({
            value: core.serialization.lazy(async () => (await import("../../..")).ErrorInfo),
        }),
        finished: core.serialization.object({}),
    })
    .transform<SeedTrace.WorkspaceSubmissionUpdateInfo>({
        transform: (value) => value,
        untransform: (value) => value,
    });

export declare namespace WorkspaceSubmissionUpdateInfo {
    type Raw =
        | WorkspaceSubmissionUpdateInfo.Running
        | WorkspaceSubmissionUpdateInfo.Ran
        | WorkspaceSubmissionUpdateInfo.Stopped
        | WorkspaceSubmissionUpdateInfo.Traced
        | WorkspaceSubmissionUpdateInfo.TracedV2
        | WorkspaceSubmissionUpdateInfo.Errored
        | WorkspaceSubmissionUpdateInfo.Finished;

    interface Running {
        type: "running";
        value: serializers.RunningSubmissionState.Raw;
    }

    interface Ran extends serializers.WorkspaceRunDetails.Raw {
        type: "ran";
    }

    interface Stopped {
        type: "stopped";
    }

    interface Traced {
        type: "traced";
    }

    interface TracedV2 extends serializers.WorkspaceTracedUpdate.Raw {
        type: "tracedV2";
    }

    interface Errored {
        type: "errored";
        value: serializers.ErrorInfo.Raw;
    }

    interface Finished {
        type: "finished";
    }
}
