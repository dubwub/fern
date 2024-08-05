# This file was auto-generated by Fern from our API Definition.

from ....core.pydantic_utilities import UniversalBaseModel
import typing
from ...commons.types.language import Language
from .problem_files import ProblemFiles
from ....core.pydantic_utilities import IS_PYDANTIC_V2
import pydantic


class GetDefaultStarterFilesResponse(UniversalBaseModel):
    files: typing.Dict[Language, ProblemFiles]

    if IS_PYDANTIC_V2:
        model_config: typing.ClassVar[pydantic.ConfigDict] = pydantic.ConfigDict(
            extra="forbid"
        )  # type: ignore # Pydantic v2
    else:

        class Config:
            extra = pydantic.Extra.forbid
