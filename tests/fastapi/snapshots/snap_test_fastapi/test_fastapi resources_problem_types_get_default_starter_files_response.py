# This file was auto-generated by Fern from our API Definition.

# type: ignore
# flake8: noqa
# fmt: off
# isort: skip_file

from __future__ import annotations

import typing

import pydantic
import typing_extensions

from ...commons.types.language import Language
from .problem_files import ProblemFiles


class GetDefaultStarterFilesResponse(pydantic.BaseModel):
    files: typing.Dict[Language, ProblemFiles]

    class Validators:
        """
        Use this class to add validators to the Pydantic model.

            @GetDefaultStarterFilesResponse.Validators.field("files")
            def validate_files(v: typing.Dict[Language, ProblemFiles], values: GetDefaultStarterFilesResponse.Partial) -> typing.Dict[Language, ProblemFiles]:
                ...
        """

        _files_validators: typing.ClassVar[typing.List[GetDefaultStarterFilesResponse.Validators.FilesValidator]] = []

        @typing.overload  # type: ignore
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["files"]
        ) -> typing.Callable[
            [GetDefaultStarterFilesResponse.Validators.FilesValidator],
            GetDefaultStarterFilesResponse.Validators.FilesValidator,
        ]:
            ...

        @classmethod
        def field(cls, field_name: str) -> typing.Any:
            def decorator(validator: typing.Any) -> typing.Any:
                if field_name == "files":
                    cls._files_validators.append(validator)
                return validator

            return decorator

        class FilesValidator(typing_extensions.Protocol):
            def __call__(
                self, v: typing.Dict[Language, ProblemFiles], *, values: GetDefaultStarterFilesResponse.Partial
            ) -> typing.Dict[Language, ProblemFiles]:
                ...

    @pydantic.validator("files")
    def _validate_files(
        cls, v: typing.Dict[Language, ProblemFiles], values: typing.Dict[Language, ProblemFiles]
    ) -> typing.Dict[Language, ProblemFiles]:
        for validator in GetDefaultStarterFilesResponse.Validators._files_validators:
            v = validator(v, values=values)
        return v

    class Partial(typing.TypedDict):
        files: typing_extensions.NotRequired[typing.Dict[Language, ProblemFiles]]

    def json(self, **kwargs: typing.Any) -> str:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().json(**kwargs_with_defaults)

    def dict(self, **kwargs: typing.Any) -> typing.Dict[str, typing.Any]:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().dict(**kwargs_with_defaults)

    class Config:
        frozen = True
