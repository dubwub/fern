# This file was auto-generated by Fern from our API Definition.

# type: ignore
# flake8: noqa
# fmt: off
# isort: skip_file

from __future__ import annotations

import typing

import pydantic
import typing_extensions


class TestCaseHiddenGrade(pydantic.BaseModel):
    passed: bool

    class Validators:
        """
        Use this class to add validators to the Pydantic model.

            @TestCaseHiddenGrade.Validators.field("passed")
            def validate_passed(v: bool, values: TestCaseHiddenGrade.Partial) -> bool:
                ...
        """

        _passed_validators: typing.ClassVar[typing.List[TestCaseHiddenGrade.Validators.PassedValidator]] = []

        @typing.overload  # type: ignore
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["passed"]
        ) -> typing.Callable[
            [TestCaseHiddenGrade.Validators.PassedValidator], TestCaseHiddenGrade.Validators.PassedValidator
        ]:
            ...

        @classmethod
        def field(cls, field_name: str) -> typing.Any:
            def decorator(validator: typing.Any) -> typing.Any:
                if field_name == "passed":
                    cls._passed_validators.append(validator)
                return validator

            return decorator

        class PassedValidator(typing_extensions.Protocol):
            def __call__(self, v: bool, *, values: TestCaseHiddenGrade.Partial) -> bool:
                ...

    @pydantic.validator("passed")
    def _validate_passed(cls, v: bool, values: bool) -> bool:
        for validator in TestCaseHiddenGrade.Validators._passed_validators:
            v = validator(v, values=values)
        return v

    class Partial(typing.TypedDict):
        passed: typing_extensions.NotRequired[bool]

    def json(self, **kwargs: typing.Any) -> str:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().json(**kwargs_with_defaults)

    def dict(self, **kwargs: typing.Any) -> typing.Dict[str, typing.Any]:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().dict(**kwargs_with_defaults)

    class Config:
        frozen = True
