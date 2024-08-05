# This file was auto-generated by Fern from our API Definition.

from ...core.pydantic_utilities import UniversalBaseModel
from .movie_id import MovieId
import pydantic
from ...core.pydantic_utilities import IS_PYDANTIC_V2
import typing


class Movie(UniversalBaseModel):
    id: MovieId
    title: str
    rating: float = pydantic.Field()
    """
    The rating scale is one to five stars
    """

    if IS_PYDANTIC_V2:
        model_config: typing.ClassVar[pydantic.ConfigDict] = pydantic.ConfigDict(
            extra="allow", frozen=True
        )  # type: ignore # Pydantic v2
    else:

        class Config:
            frozen = True
            smart_union = True
            extra = pydantic.Extra.allow
