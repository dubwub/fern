# This file was auto-generated by Fern from our API Definition.

from __future__ import annotations
from .......core.pydantic_utilities import UniversalBaseModel
from ......commons.list_type import ListType
from ......commons.map_type import MapType
import pydantic
from .non_void_function_signature import NonVoidFunctionSignature
from .......core.pydantic_utilities import IS_PYDANTIC_V2
import typing
from .......core.pydantic_utilities import update_forward_refs


class GetBasicSolutionFileRequest(UniversalBaseModel):
    method_name: str = pydantic.Field(alias="methodName")
    signature: NonVoidFunctionSignature

    if IS_PYDANTIC_V2:
        model_config: typing.ClassVar[pydantic.ConfigDict] = pydantic.ConfigDict(extra="allow")  # type: ignore # Pydantic v2
    else:

        class Config:
            extra = pydantic.Extra.allow


update_forward_refs(ListType, GetBasicSolutionFileRequest=GetBasicSolutionFileRequest)
update_forward_refs(MapType, GetBasicSolutionFileRequest=GetBasicSolutionFileRequest)
