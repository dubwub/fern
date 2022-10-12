# This file was auto-generated by Fern from our API Definition.

# type: ignore
# flake8: noqa
# fmt: off
# isort: skip_file

from __future__ import annotations

import typing

import pydantic
import typing_extensions


class UpdateProblemResponse(pydantic.BaseModel):
    problem_version: int = pydantic.Field(alias="problemVersion")

    class Validators:
        """
        Use this class to add validators to the Pydantic model.

            @UpdateProblemResponse.Validators.field("problem_version")
            def validate_problem_version(v: int, values: UpdateProblemResponse.Partial) -> int:
                ...
        """

        _problem_version_validators: typing.ClassVar[
            typing.List[UpdateProblemResponse.Validators.ProblemVersionValidator]
        ] = []

        @typing.overload  # type: ignore
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["problem_version"]
        ) -> typing.Callable[
            [UpdateProblemResponse.Validators.ProblemVersionValidator],
            UpdateProblemResponse.Validators.ProblemVersionValidator,
        ]:
            ...

        @classmethod
        def field(cls, field_name: str) -> typing.Any:
            def decorator(validator: typing.Any) -> typing.Any:
                if field_name == "problem_version":
                    cls._problem_version_validators.append(validator)
                return validator

            return decorator

        class ProblemVersionValidator(typing_extensions.Protocol):
            def __call__(self, v: int, *, values: UpdateProblemResponse.Partial) -> int:
                ...

    @pydantic.validator("problem_version")
    def _validate_problem_version(cls, v: int, values: int) -> int:
        for validator in UpdateProblemResponse.Validators._problem_version_validators:
            v = validator(v, values=values)
        return v

    class Partial(typing.TypedDict):
        problem_version: typing_extensions.NotRequired[int]

    def json(self, **kwargs: typing.Any) -> str:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().json(**kwargs_with_defaults)

    def dict(self, **kwargs: typing.Any) -> typing.Dict[str, typing.Any]:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().dict(**kwargs_with_defaults)

    class Config:
        frozen = True
        allow_population_by_field_name = True
