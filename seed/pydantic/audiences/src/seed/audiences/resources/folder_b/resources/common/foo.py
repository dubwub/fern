# This file was auto-generated by Fern from our API Definition.

from .....core.pydantic_utilities import UniversalBaseModel
import typing
from ....folder_c.resources.common.foo import (
    Foo as resources_folder_c_resources_common_foo_Foo,
)
from .....core.pydantic_utilities import IS_PYDANTIC_V2
import pydantic


class Foo(UniversalBaseModel):
    foo: typing.Optional[resources_folder_c_resources_common_foo_Foo] = None

    if IS_PYDANTIC_V2:
        model_config: typing.ClassVar[pydantic.ConfigDict] = pydantic.ConfigDict(
            extra="allow"
        )  # type: ignore # Pydantic v2
    else:

        class Config:
            extra = pydantic.Extra.allow
