# This file was auto-generated by Fern from our API Definition.

from ......core.abstract_fern_service import AbstractFernService
from .....types.resources.union.types.animal import Animal
from ......security import ApiAuth
import abc
import fastapi
import inspect
import typing
from ......security import FernAuth
from ......core.exceptions.fern_http_exception import FernHTTPException
import logging
import functools
from ......core.route_args import get_route_args


class AbstractEndpointsUnionService(AbstractFernService):
    """
    AbstractEndpointsUnionService is an abstract class containing the methods that you should implement.

    Each method is associated with an API route, which will be registered
    with FastAPI when you register your implementation using Fern's register()
    function.
    """

    @abc.abstractmethod
    def get_and_return_union(self, *, body: Animal, auth: ApiAuth) -> Animal: ...

    """
    Below are internal methods used by Fern to register your implementation.
    You can ignore them.
    """

    @classmethod
    def _init_fern(cls, router: fastapi.APIRouter) -> None:
        cls.__init_get_and_return_union(router=router)

    @classmethod
    def __init_get_and_return_union(cls, router: fastapi.APIRouter) -> None:
        endpoint_function = inspect.signature(cls.get_and_return_union)
        new_parameters: typing.List[inspect.Parameter] = []
        for index, (parameter_name, parameter) in enumerate(
            endpoint_function.parameters.items()
        ):
            if index == 0:
                new_parameters.append(parameter.replace(default=fastapi.Depends(cls)))
            elif parameter_name == "body":
                new_parameters.append(parameter.replace(default=fastapi.Body(...)))
            elif parameter_name == "auth":
                new_parameters.append(
                    parameter.replace(default=fastapi.Depends(FernAuth))
                )
            else:
                new_parameters.append(parameter)
        setattr(
            cls.get_and_return_union,
            "__signature__",
            endpoint_function.replace(parameters=new_parameters),
        )

        @functools.wraps(cls.get_and_return_union)
        def wrapper(*args: typing.Any, **kwargs: typing.Any) -> Animal:
            try:
                return cls.get_and_return_union(*args, **kwargs)
            except FernHTTPException as e:
                logging.getLogger(f"{cls.__module__}.{cls.__name__}").warn(
                    f"Endpoint 'get_and_return_union' unexpectedly threw {e.__class__.__name__}. "
                    + f"If this was intentional, please add {e.__class__.__name__} to "
                    + "the endpoint's errors list in your Fern Definition."
                )
                raise e

        # this is necessary for FastAPI to find forward-ref'ed type hints.
        # https://github.com/tiangolo/fastapi/pull/5077
        wrapper.__globals__.update(cls.get_and_return_union.__globals__)

        router.post(
            path="/union",
            response_model=Animal,
            description=AbstractEndpointsUnionService.get_and_return_union.__doc__,
            **get_route_args(cls.get_and_return_union, default_tag="endpoints.union"),
        )(wrapper)
