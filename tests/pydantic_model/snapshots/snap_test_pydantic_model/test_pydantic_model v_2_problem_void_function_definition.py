# This file was auto-generated by Fern from our API Definition.

# type: ignore
# flake8: noqa
# fmt: off
# isort: skip_file

from __future__ import annotations

import typing

import pydantic
import typing_extensions

from .function_implementation_for_multiple_languages import FunctionImplementationForMultipleLanguages
from .parameter import Parameter


class VoidFunctionDefinition(pydantic.BaseModel):
    parameters: typing.List[Parameter]
    code: FunctionImplementationForMultipleLanguages

    class Validators:
        """
        Use this class to add validators to the Pydantic model.

            @VoidFunctionDefinition.Validators.field("parameters")
            def validate_parameters(v: typing.List[Parameter], values: VoidFunctionDefinition.Partial) -> typing.List[Parameter]:
                ...

            @VoidFunctionDefinition.Validators.field("code")
            def validate_code(v: FunctionImplementationForMultipleLanguages, values: VoidFunctionDefinition.Partial) -> FunctionImplementationForMultipleLanguages:
                ...
        """

        _parameters_validators: typing.ClassVar[typing.List[VoidFunctionDefinition.Validators.ParametersValidator]] = []
        _code_validators: typing.ClassVar[typing.List[VoidFunctionDefinition.Validators.CodeValidator]] = []

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["parameters"]
        ) -> typing.Callable[
            [VoidFunctionDefinition.Validators.ParametersValidator],
            VoidFunctionDefinition.Validators.ParametersValidator,
        ]:
            ...

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["code"]
        ) -> typing.Callable[
            [VoidFunctionDefinition.Validators.CodeValidator], VoidFunctionDefinition.Validators.CodeValidator
        ]:
            ...

        @classmethod
        def field(cls, field_name: str) -> typing.Any:
            def decorator(validator: typing.Any) -> typing.Any:
                if field_name == "parameters":
                    cls._parameters_validators.append(validator)
                if field_name == "code":
                    cls._code_validators.append(validator)
                return validator

            return decorator

        class ParametersValidator(typing_extensions.Protocol):
            def __call__(
                self, v: typing.List[Parameter], *, values: VoidFunctionDefinition.Partial
            ) -> typing.List[Parameter]:
                ...

        class CodeValidator(typing_extensions.Protocol):
            def __call__(
                self, v: FunctionImplementationForMultipleLanguages, *, values: VoidFunctionDefinition.Partial
            ) -> FunctionImplementationForMultipleLanguages:
                ...

    @pydantic.validator("parameters")
    def _validate_parameters(cls, v: typing.List[Parameter], values: typing.List[Parameter]) -> typing.List[Parameter]:
        for validator in VoidFunctionDefinition.Validators._parameters_validators:
            v = validator(v, values=values)
        return v

    @pydantic.validator("code")
    def _validate_code(
        cls, v: FunctionImplementationForMultipleLanguages, values: FunctionImplementationForMultipleLanguages
    ) -> FunctionImplementationForMultipleLanguages:
        for validator in VoidFunctionDefinition.Validators._code_validators:
            v = validator(v, values=values)
        return v

    class Partial(typing.TypedDict):
        parameters: typing_extensions.NotRequired[typing.List[Parameter]]
        code: typing_extensions.NotRequired[FunctionImplementationForMultipleLanguages]

    def json(self, **kwargs: typing.Any) -> str:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().json(**kwargs_with_defaults)

    def dict(self, **kwargs: typing.Any) -> typing.Dict[str, typing.Any]:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().dict(**kwargs_with_defaults)

    class Config:
        frozen = True
