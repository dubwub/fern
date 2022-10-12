# This file was auto-generated by Fern from our API Definition.

# type: ignore
# flake8: noqa
# fmt: off
# isort: skip_file

from __future__ import annotations

import typing

import pydantic
import typing_extensions

from ..commons.language import Language
from .submission_type_state import SubmissionTypeState


class GetSubmissionStateResponse(pydantic.BaseModel):
    time_submitted: typing.Optional[str] = pydantic.Field(alias="timeSubmitted")
    submission: str
    language: Language
    submission_type_state: SubmissionTypeState = pydantic.Field(alias="submissionTypeState")

    class Validators:
        """
        Use this class to add validators to the Pydantic model.

            @GetSubmissionStateResponse.Validators.field("time_submitted")
            def validate_time_submitted(v: typing.Optional[str], values: GetSubmissionStateResponse.Partial) -> typing.Optional[str]:
                ...

            @GetSubmissionStateResponse.Validators.field("submission")
            def validate_submission(v: str, values: GetSubmissionStateResponse.Partial) -> str:
                ...

            @GetSubmissionStateResponse.Validators.field("language")
            def validate_language(v: Language, values: GetSubmissionStateResponse.Partial) -> Language:
                ...

            @GetSubmissionStateResponse.Validators.field("submission_type_state")
            def validate_submission_type_state(v: SubmissionTypeState, values: GetSubmissionStateResponse.Partial) -> SubmissionTypeState:
                ...
        """

        _time_submitted_validators: typing.ClassVar[
            typing.List[GetSubmissionStateResponse.Validators.TimeSubmittedValidator]
        ] = []
        _submission_validators: typing.ClassVar[
            typing.List[GetSubmissionStateResponse.Validators.SubmissionValidator]
        ] = []
        _language_validators: typing.ClassVar[typing.List[GetSubmissionStateResponse.Validators.LanguageValidator]] = []
        _submission_type_state_validators: typing.ClassVar[
            typing.List[GetSubmissionStateResponse.Validators.SubmissionTypeStateValidator]
        ] = []

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["time_submitted"]
        ) -> typing.Callable[
            [GetSubmissionStateResponse.Validators.TimeSubmittedValidator],
            GetSubmissionStateResponse.Validators.TimeSubmittedValidator,
        ]:
            ...

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["submission"]
        ) -> typing.Callable[
            [GetSubmissionStateResponse.Validators.SubmissionValidator],
            GetSubmissionStateResponse.Validators.SubmissionValidator,
        ]:
            ...

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["language"]
        ) -> typing.Callable[
            [GetSubmissionStateResponse.Validators.LanguageValidator],
            GetSubmissionStateResponse.Validators.LanguageValidator,
        ]:
            ...

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["submission_type_state"]
        ) -> typing.Callable[
            [GetSubmissionStateResponse.Validators.SubmissionTypeStateValidator],
            GetSubmissionStateResponse.Validators.SubmissionTypeStateValidator,
        ]:
            ...

        @classmethod
        def field(cls, field_name: str) -> typing.Any:
            def decorator(validator: typing.Any) -> typing.Any:
                if field_name == "time_submitted":
                    cls._time_submitted_validators.append(validator)
                if field_name == "submission":
                    cls._submission_validators.append(validator)
                if field_name == "language":
                    cls._language_validators.append(validator)
                if field_name == "submission_type_state":
                    cls._submission_type_state_validators.append(validator)
                return validator

            return decorator

        class TimeSubmittedValidator(typing_extensions.Protocol):
            def __call__(
                self, v: typing.Optional[str], *, values: GetSubmissionStateResponse.Partial
            ) -> typing.Optional[str]:
                ...

        class SubmissionValidator(typing_extensions.Protocol):
            def __call__(self, v: str, *, values: GetSubmissionStateResponse.Partial) -> str:
                ...

        class LanguageValidator(typing_extensions.Protocol):
            def __call__(self, v: Language, *, values: GetSubmissionStateResponse.Partial) -> Language:
                ...

        class SubmissionTypeStateValidator(typing_extensions.Protocol):
            def __call__(
                self, v: SubmissionTypeState, *, values: GetSubmissionStateResponse.Partial
            ) -> SubmissionTypeState:
                ...

    @pydantic.validator("time_submitted")
    def _validate_time_submitted(cls, v: typing.Optional[str], values: typing.Optional[str]) -> typing.Optional[str]:
        for validator in GetSubmissionStateResponse.Validators._time_submitted_validators:
            v = validator(v, values=values)
        return v

    @pydantic.validator("submission")
    def _validate_submission(cls, v: str, values: str) -> str:
        for validator in GetSubmissionStateResponse.Validators._submission_validators:
            v = validator(v, values=values)
        return v

    @pydantic.validator("language")
    def _validate_language(cls, v: Language, values: Language) -> Language:
        for validator in GetSubmissionStateResponse.Validators._language_validators:
            v = validator(v, values=values)
        return v

    @pydantic.validator("submission_type_state")
    def _validate_submission_type_state(
        cls, v: SubmissionTypeState, values: SubmissionTypeState
    ) -> SubmissionTypeState:
        for validator in GetSubmissionStateResponse.Validators._submission_type_state_validators:
            v = validator(v, values=values)
        return v

    class Partial(typing.TypedDict):
        time_submitted: typing_extensions.NotRequired[typing.Optional[str]]
        submission: typing_extensions.NotRequired[str]
        language: typing_extensions.NotRequired[Language]
        submission_type_state: typing_extensions.NotRequired[SubmissionTypeState]

    def json(self, **kwargs: typing.Any) -> str:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().json(**kwargs_with_defaults)

    def dict(self, **kwargs: typing.Any) -> typing.Dict[str, typing.Any]:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().dict(**kwargs_with_defaults)

    class Config:
        frozen = True
        allow_population_by_field_name = True
