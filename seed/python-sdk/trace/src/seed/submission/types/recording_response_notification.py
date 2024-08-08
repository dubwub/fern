# This file was auto-generated by Fern from our API Definition.

import typing

import pydantic

from ...core.pydantic_utilities import IS_PYDANTIC_V2, UniversalBaseModel
from .lightweight_stackframe_information import LightweightStackframeInformation
from .submission_id import SubmissionId
from .traced_file import TracedFile


class RecordingResponseNotification(UniversalBaseModel):
    submission_id: SubmissionId = pydantic.Field(alias="submissionId")
    test_case_id: typing.Optional[str] = pydantic.Field(alias="testCaseId", default=None)
    line_number: int = pydantic.Field(alias="lineNumber")
    lightweight_stack_info: LightweightStackframeInformation = pydantic.Field(alias="lightweightStackInfo")
    traced_file: typing.Optional[TracedFile] = pydantic.Field(alias="tracedFile", default=None)

    if IS_PYDANTIC_V2:
        model_config: typing.ClassVar[pydantic.ConfigDict] = pydantic.ConfigDict(extra="allow", frozen=True)  # type: ignore # Pydantic v2
    else:

        class Config:
            frozen = True
            smart_union = True
            extra = pydantic.Extra.allow
