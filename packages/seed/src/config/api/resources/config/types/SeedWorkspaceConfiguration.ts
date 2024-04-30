/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as FernSeedConfig from "../../..";

export interface SeedWorkspaceConfiguration {
    irVersion: string;
    language?: FernSeedConfig.Language;
    defaultCustomConfig?: Record<string, unknown>;
    defaultOutputMode: FernSeedConfig.OutputMode;
    generatorType: FernSeedConfig.GeneratorType;
    docker: string;
    dockerCommand?: FernSeedConfig.DockerCommand;
    local?: FernSeedConfig.LocalBuildInfo;
    /** Configuration that will be used for any custom fixture specified by --custom-fixture */
    customFixtureConfig?: FernSeedConfig.FixtureConfigurations;
    fixtures?: Record<string, FernSeedConfig.FixtureConfigurations[]>;
    scripts?: FernSeedConfig.ScriptConfig[];
    /**
     * List any fixtures that are okay to fail. For normal fixtures
     * just list the fixture name. For configured fixture list {fixture}:{outputFolder}.
     */
    allowedFailures?: string[];
    features?: FernSeedConfig.GeneratorFeatures;
}
