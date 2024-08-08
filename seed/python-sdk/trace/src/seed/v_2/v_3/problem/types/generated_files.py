# This file was auto-generated by Fern from our API Definition.

import typing

import pydantic

from .....commons.types.language import Language
from .....core.pydantic_utilities import IS_PYDANTIC_V2, UniversalBaseModel
from .files import Files


class GeneratedFiles(UniversalBaseModel):
    generated_test_case_files: typing.Dict[Language, Files] = pydantic.Field(alias="generatedTestCaseFiles")
    generated_template_files: typing.Dict[Language, Files] = pydantic.Field(alias="generatedTemplateFiles")
    other: typing.Dict[Language, Files]

    if IS_PYDANTIC_V2:
        model_config: typing.ClassVar[pydantic.ConfigDict] = pydantic.ConfigDict(extra="allow", frozen=True)  # type: ignore # Pydantic v2
    else:

        class Config:
            frozen = True
            smart_union = True
            extra = pydantic.Extra.allow
