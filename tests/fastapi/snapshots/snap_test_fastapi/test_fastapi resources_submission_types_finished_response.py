# This file was auto-generated by Fern from our API Definition.

# type: ignore
# flake8: noqa
# fmt: off
# isort: skip_file

from __future__ import annotations

import typing

import pydantic
import typing_extensions

from .submission_id import SubmissionId


class FinishedResponse(pydantic.BaseModel):
    submission_id: SubmissionId = pydantic.Field(alias="submissionId")

    class Validators:
        """
        Use this class to add validators to the Pydantic model.

            @FinishedResponse.Validators.field("submission_id")
            def validate_submission_id(v: SubmissionId, values: FinishedResponse.Partial) -> SubmissionId:
                ...
        """

        _submission_id_validators: typing.ClassVar[typing.List[FinishedResponse.Validators.SubmissionIdValidator]] = []

        @typing.overload  # type: ignore
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["submission_id"]
        ) -> typing.Callable[
            [FinishedResponse.Validators.SubmissionIdValidator], FinishedResponse.Validators.SubmissionIdValidator
        ]:
            ...

        @classmethod
        def field(cls, field_name: str) -> typing.Any:
            def decorator(validator: typing.Any) -> typing.Any:
                if field_name == "submission_id":
                    cls._submission_id_validators.append(validator)
                return validator

            return decorator

        class SubmissionIdValidator(typing_extensions.Protocol):
            def __call__(self, v: SubmissionId, *, values: FinishedResponse.Partial) -> SubmissionId:
                ...

    @pydantic.validator("submission_id")
    def _validate_submission_id(cls, v: SubmissionId, values: SubmissionId) -> SubmissionId:
        for validator in FinishedResponse.Validators._submission_id_validators:
            v = validator(v, values=values)
        return v

    class Partial(typing.TypedDict):
        submission_id: typing_extensions.NotRequired[SubmissionId]

    def json(self, **kwargs: typing.Any) -> str:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().json(**kwargs_with_defaults)

    def dict(self, **kwargs: typing.Any) -> typing.Dict[str, typing.Any]:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().dict(**kwargs_with_defaults)

    class Config:
        frozen = True
        allow_population_by_field_name = True
