# This file was auto-generated by Fern from our API Definition.

from __future__ import annotations

import typing

import pydantic

from ...core.pydantic_utilities import IS_PYDANTIC_V2, UniversalBaseModel, UniversalRootModel

T_Result = typing.TypeVar("T_Result")


class _Factory:
    def fern(self, value: typing.Literal["fern"]) -> UnionWithLiteral:
        if IS_PYDANTIC_V2:
            return UnionWithLiteral(root=_UnionWithLiteral.Fern(type="fern", value=value))
        else:
            return UnionWithLiteral(__root__=_UnionWithLiteral.Fern(type="fern", value=value))


class UnionWithLiteral(UniversalRootModel):
    factory: typing.ClassVar[_Factory] = _Factory()

    if IS_PYDANTIC_V2:
        root: typing.Union[_UnionWithLiteral.Fern]

        def get_as_union(self) -> typing.Union[_UnionWithLiteral.Fern]:
            return self.root

    else:
        __root__: typing.Union[_UnionWithLiteral.Fern]

        def get_as_union(self) -> typing.Union[_UnionWithLiteral.Fern]:
            return self.__root__

    def visit(self, fern: typing.Callable[[typing.Literal["fern"]], T_Result]) -> T_Result:
        unioned_value = self.get_as_union()
        if unioned_value.type == "fern":
            return fern(unioned_value.value)


class _UnionWithLiteral:
    class Fern(UniversalBaseModel):
        type: typing.Literal["fern"] = "fern"
        value: typing.Literal["fern"]

        if IS_PYDANTIC_V2:
            model_config: typing.ClassVar[pydantic.ConfigDict] = pydantic.ConfigDict(frozen=True)  # type: ignore # Pydantic v2
        else:

            class Config:
                frozen = True
                smart_union = True
