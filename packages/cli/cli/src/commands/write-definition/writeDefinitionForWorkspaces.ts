import { join, RelativeFilePath } from "@fern-api/fs-utils";
import { DEFINITION_DIRECTORY, ROOT_API_FILENAME } from "@fern-api/project-configuration";
import { Project } from "@fern-api/project-loader";
import { TaskContext } from "@fern-api/task-context";
import { FernWorkspace } from "@fern-api/workspace-loader";
import { formatDefinitionFile } from "@fern-api/yaml-formatter";
import { mkdir, writeFile } from "fs/promises";
import yaml from "js-yaml";
import { entries } from "lodash-es";
import { CliContext } from "../../cli-context/CliContext";
import { convertOpenApiWorkspaceToFernWorkspace } from "../generate/generateWorkspaces";

export async function writeDefinitionForWorkspaces({
    project,
    cliContext,
}: {
    project: Project;
    cliContext: CliContext;
}): Promise<void> {
    await Promise.all(
        project.workspaces.map(async (workspace) => {
            await cliContext.runTaskForWorkspace(workspace, async (context) => {
                if (workspace.type === "openapi") {
                    const fernWorkspace = await convertOpenApiWorkspaceToFernWorkspace(workspace, context);
                    await writeDefinitionForWorkspace(fernWorkspace, context);
                }
            });
        })
    );
}

async function writeDefinitionForWorkspace(workspace: FernWorkspace, taskContext: TaskContext) {
    const directoryOfDefinition = join(workspace.absolutePathToWorkspace, RelativeFilePath.of(DEFINITION_DIRECTORY));
    await mkdir(directoryOfDefinition);
    await writeFile(
        join(directoryOfDefinition, RelativeFilePath.of(ROOT_API_FILENAME)),
        yaml.dump(workspace.definition.rootApiFile.contents)
    );
    for (const [relativePath, definitionFile] of entries(workspace.definition.namedDefinitionFiles)) {
        const absoluteFilepath = join(directoryOfDefinition, RelativeFilePath.of(relativePath));
        let fileContents = yaml.dump(definitionFile.contents);
        try {
            fileContents = formatDefinitionFile({
                fileContents: yaml.dump(definitionFile.contents),
                absoluteFilepath,
            });
        } catch (err) {
            taskContext.logger.debug(`Failed to format ${relativePath}: ${JSON.stringify(err)}`);
        }
        await writeFile(absoluteFilepath, fileContents);
    }
}
