# This file was auto-generated by Fern from our API Definition.

from __future__ import annotations
from ...core.pydantic_utilities import UniversalBaseModel
import typing
from ...core.pydantic_utilities import IS_PYDANTIC_V2
import pydantic
from .object_value import ObjectValue
from .primitive_value import PrimitiveValue
from ...core.pydantic_utilities import update_forward_refs


class ContainerValue_List(UniversalBaseModel):
    value: typing.List[FieldValue]
    type: typing.Literal["list"] = "list"

    if IS_PYDANTIC_V2:
        model_config: typing.ClassVar[pydantic.ConfigDict] = pydantic.ConfigDict(
            frozen=True
        )  # type: ignore # Pydantic v2
    else:

        class Config:
            frozen = True
            smart_union = True


class ContainerValue_Optional(UniversalBaseModel):
    value: typing.Optional[FieldValue] = None
    type: typing.Literal["optional"] = "optional"

    if IS_PYDANTIC_V2:
        model_config: typing.ClassVar[pydantic.ConfigDict] = pydantic.ConfigDict(
            frozen=True
        )  # type: ignore # Pydantic v2
    else:

        class Config:
            frozen = True
            smart_union = True


ContainerValue = typing.Union[ContainerValue_List, ContainerValue_Optional]
from .field_value import FieldValue  # noqa: E402

update_forward_refs(ContainerValue_List, FieldValue=FieldValue)
update_forward_refs(ContainerValue_Optional, FieldValue=FieldValue)
