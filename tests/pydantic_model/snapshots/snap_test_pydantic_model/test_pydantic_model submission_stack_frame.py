# This file was auto-generated by Fern from our API Definition.

# type: ignore
# flake8: noqa
# fmt: off
# isort: skip_file

from __future__ import annotations

import typing

import pydantic
import typing_extensions

from .scope import Scope


class StackFrame(pydantic.BaseModel):
    method_name: str = pydantic.Field(alias="methodName")
    line_number: int = pydantic.Field(alias="lineNumber")
    scopes: typing.List[Scope]

    class Validators:
        """
        Use this class to add validators to the Pydantic model.

            @StackFrame.Validators.field("method_name")
            def validate_method_name(v: str, values: StackFrame.Partial) -> str:
                ...

            @StackFrame.Validators.field("line_number")
            def validate_line_number(v: int, values: StackFrame.Partial) -> int:
                ...

            @StackFrame.Validators.field("scopes")
            def validate_scopes(v: typing.List[Scope], values: StackFrame.Partial) -> typing.List[Scope]:
                ...
        """

        _method_name_validators: typing.ClassVar[typing.List[StackFrame.Validators.MethodNameValidator]] = []
        _line_number_validators: typing.ClassVar[typing.List[StackFrame.Validators.LineNumberValidator]] = []
        _scopes_validators: typing.ClassVar[typing.List[StackFrame.Validators.ScopesValidator]] = []

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["method_name"]
        ) -> typing.Callable[[StackFrame.Validators.MethodNameValidator], StackFrame.Validators.MethodNameValidator]:
            ...

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["line_number"]
        ) -> typing.Callable[[StackFrame.Validators.LineNumberValidator], StackFrame.Validators.LineNumberValidator]:
            ...

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["scopes"]
        ) -> typing.Callable[[StackFrame.Validators.ScopesValidator], StackFrame.Validators.ScopesValidator]:
            ...

        @classmethod
        def field(cls, field_name: str) -> typing.Any:
            def decorator(validator: typing.Any) -> typing.Any:
                if field_name == "method_name":
                    cls._method_name_validators.append(validator)
                if field_name == "line_number":
                    cls._line_number_validators.append(validator)
                if field_name == "scopes":
                    cls._scopes_validators.append(validator)
                return validator

            return decorator

        class MethodNameValidator(typing_extensions.Protocol):
            def __call__(self, v: str, *, values: StackFrame.Partial) -> str:
                ...

        class LineNumberValidator(typing_extensions.Protocol):
            def __call__(self, v: int, *, values: StackFrame.Partial) -> int:
                ...

        class ScopesValidator(typing_extensions.Protocol):
            def __call__(self, v: typing.List[Scope], *, values: StackFrame.Partial) -> typing.List[Scope]:
                ...

    @pydantic.validator("method_name")
    def _validate_method_name(cls, v: str, values: str) -> str:
        for validator in StackFrame.Validators._method_name_validators:
            v = validator(v, values=values)
        return v

    @pydantic.validator("line_number")
    def _validate_line_number(cls, v: int, values: int) -> int:
        for validator in StackFrame.Validators._line_number_validators:
            v = validator(v, values=values)
        return v

    @pydantic.validator("scopes")
    def _validate_scopes(cls, v: typing.List[Scope], values: typing.List[Scope]) -> typing.List[Scope]:
        for validator in StackFrame.Validators._scopes_validators:
            v = validator(v, values=values)
        return v

    class Partial(typing.TypedDict):
        method_name: typing_extensions.NotRequired[str]
        line_number: typing_extensions.NotRequired[int]
        scopes: typing_extensions.NotRequired[typing.List[Scope]]

    def json(self, **kwargs: typing.Any) -> str:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().json(**kwargs_with_defaults)

    def dict(self, **kwargs: typing.Any) -> typing.Dict[str, typing.Any]:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().dict(**kwargs_with_defaults)

    class Config:
        frozen = True
        allow_population_by_field_name = True
