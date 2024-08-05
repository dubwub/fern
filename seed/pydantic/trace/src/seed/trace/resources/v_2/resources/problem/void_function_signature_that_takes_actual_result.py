# This file was auto-generated by Fern from our API Definition.

from .....core.pydantic_utilities import UniversalBaseModel
import typing
from .parameter import Parameter
from ....commons.variable_type import VariableType
import pydantic
from .....core.pydantic_utilities import IS_PYDANTIC_V2


class VoidFunctionSignatureThatTakesActualResult(UniversalBaseModel):
    parameters: typing.List[Parameter]
    actual_result_type: VariableType = pydantic.Field(alias="actualResultType")

    if IS_PYDANTIC_V2:
        model_config: typing.ClassVar[pydantic.ConfigDict] = pydantic.ConfigDict(
            extra="allow"
        )  # type: ignore # Pydantic v2
    else:

        class Config:
            extra = pydantic.Extra.allow
