# This file was auto-generated by Fern from our API Definition.

import datetime as dt
import typing

from ...core.datetime_utils import serialize_datetime
from ...core.pydantic_utilities import pydantic_v1
from .lightweight_stackframe_information import LightweightStackframeInformation
from .submission_id import SubmissionId
from .traced_file import TracedFile


class RecordingResponseNotification(pydantic_v1.BaseModel):
    submission_id: SubmissionId = pydantic_v1.Field(alias="submissionId")
    test_case_id: typing.Optional[str] = pydantic_v1.Field(
        alias="testCaseId", default=None
    )
    line_number: int = pydantic_v1.Field(alias="lineNumber")
    lightweight_stack_info: LightweightStackframeInformation = pydantic_v1.Field(
        alias="lightweightStackInfo"
    )
    traced_file: typing.Optional[TracedFile] = pydantic_v1.Field(
        alias="tracedFile", default=None
    )

    def json(self, **kwargs: typing.Any) -> str:
        kwargs_with_defaults: typing.Any = {
            "by_alias": True,
            "exclude_unset": True,
            **kwargs,
        }
        return super().json(**kwargs_with_defaults)

    def dict(self, **kwargs: typing.Any) -> typing.Dict[str, typing.Any]:
        kwargs_with_defaults: typing.Any = {
            "by_alias": True,
            "exclude_unset": True,
            **kwargs,
        }
        return super().dict(**kwargs_with_defaults)

    class Config:
        frozen = True
        smart_union = True
        allow_population_by_field_name = True
        populate_by_name = True
        extra = pydantic_v1.Extra.allow
        json_encoders = {dt.datetime: serialize_datetime}
