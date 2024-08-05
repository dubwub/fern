# This file was auto-generated by Fern from our API Definition.

import typing
import httpx
from .core.client_wrapper import SyncClientWrapper
from .types.shape import Shape
from .core.request_options import RequestOptions
from .types.type import Type
from .core.pydantic_utilities import parse_obj_as
from json.decoder import JSONDecodeError
from .core.api_error import ApiError
from .core.client_wrapper import AsyncClientWrapper

# this is used as the default value for optional parameters
OMIT = typing.cast(typing.Any, ...)


class SeedValidation:
    """
    Use this class to access the different functions within the SDK. You can instantiate any number of clients with different configuration that will propagate to these functions.

    Parameters
    ----------
    base_url : str
        The base url to use for requests from the client.

    timeout : typing.Optional[float]
        The timeout to be used, in seconds, for requests. By default the timeout is 60 seconds, unless a custom httpx client is used, in which case this default is not enforced.

    follow_redirects : typing.Optional[bool]
        Whether the default httpx client follows redirects or not, this is irrelevant if a custom httpx client is passed in.

    httpx_client : typing.Optional[httpx.Client]
        The httpx client to use for making requests, a preconfigured client is used by default, however this is useful should you want to pass in any custom httpx configuration.

    Examples
    --------
    from seed import SeedValidation

    client = SeedValidation(
        base_url="https://yourhost.com/path/to/api",
    )
    """

    def __init__(
        self,
        *,
        base_url: str,
        timeout: typing.Optional[float] = None,
        follow_redirects: typing.Optional[bool] = True,
        httpx_client: typing.Optional[httpx.Client] = None,
    ):
        _defaulted_timeout = (
            timeout if timeout is not None else 60 if httpx_client is None else None
        )
        self._client_wrapper = SyncClientWrapper(
            base_url=base_url,
            httpx_client=httpx_client
            if httpx_client is not None
            else httpx.Client(
                timeout=_defaulted_timeout, follow_redirects=follow_redirects
            )
            if follow_redirects is not None
            else httpx.Client(timeout=_defaulted_timeout),
            timeout=_defaulted_timeout,
        )

    def create(
        self,
        *,
        decimal: float = 1.1,
        even: int = 42,
        name: str = "fern",
        shape: Shape,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> Type:
        """
        Parameters
        ----------
        decimal : float

        even : int

        name : str

        shape : Shape

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        Type

        Examples
        --------
        from seed import SeedValidation

        client = SeedValidation(
            base_url="https://yourhost.com/path/to/api",
        )
        client.create(
            decimal=1.1,
            even=1,
            name="string",
            shape="SQUARE",
        )
        """
        _response = self._client_wrapper.httpx_client.request(
            "create",
            method="POST",
            json={
                "decimal": decimal,
                "even": even,
                "name": name,
                "shape": shape,
            },
            request_options=request_options,
            omit=OMIT,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    Type, parse_obj_as(type_=Type, object_=_response.json())
                )  # type: ignore
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    def get(
        self,
        *,
        decimal: float = 1.1,
        even: int = 42,
        name: str = "fern",
        request_options: typing.Optional[RequestOptions] = None,
    ) -> Type:
        """
        Parameters
        ----------
        decimal : float

        even : int

        name : str

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        Type

        Examples
        --------
        from seed import SeedValidation

        client = SeedValidation(
            base_url="https://yourhost.com/path/to/api",
        )
        client.get(
            decimal=1.1,
            even=1,
            name="string",
        )
        """
        _response = self._client_wrapper.httpx_client.request(
            method="GET",
            params={
                "decimal": decimal,
                "even": even,
                "name": name,
            },
            request_options=request_options,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    Type, parse_obj_as(type_=Type, object_=_response.json())
                )  # type: ignore
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)


class AsyncSeedValidation:
    """
    Use this class to access the different functions within the SDK. You can instantiate any number of clients with different configuration that will propagate to these functions.

    Parameters
    ----------
    base_url : str
        The base url to use for requests from the client.

    timeout : typing.Optional[float]
        The timeout to be used, in seconds, for requests. By default the timeout is 60 seconds, unless a custom httpx client is used, in which case this default is not enforced.

    follow_redirects : typing.Optional[bool]
        Whether the default httpx client follows redirects or not, this is irrelevant if a custom httpx client is passed in.

    httpx_client : typing.Optional[httpx.AsyncClient]
        The httpx client to use for making requests, a preconfigured client is used by default, however this is useful should you want to pass in any custom httpx configuration.

    Examples
    --------
    from seed import AsyncSeedValidation

    client = AsyncSeedValidation(
        base_url="https://yourhost.com/path/to/api",
    )
    """

    def __init__(
        self,
        *,
        base_url: str,
        timeout: typing.Optional[float] = None,
        follow_redirects: typing.Optional[bool] = True,
        httpx_client: typing.Optional[httpx.AsyncClient] = None,
    ):
        _defaulted_timeout = (
            timeout if timeout is not None else 60 if httpx_client is None else None
        )
        self._client_wrapper = AsyncClientWrapper(
            base_url=base_url,
            httpx_client=httpx_client
            if httpx_client is not None
            else httpx.AsyncClient(
                timeout=_defaulted_timeout, follow_redirects=follow_redirects
            )
            if follow_redirects is not None
            else httpx.AsyncClient(timeout=_defaulted_timeout),
            timeout=_defaulted_timeout,
        )

    async def create(
        self,
        *,
        decimal: float = 1.1,
        even: int = 42,
        name: str = "fern",
        shape: Shape,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> Type:
        """
        Parameters
        ----------
        decimal : float

        even : int

        name : str

        shape : Shape

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        Type

        Examples
        --------
        import asyncio

        from seed import AsyncSeedValidation

        client = AsyncSeedValidation(
            base_url="https://yourhost.com/path/to/api",
        )


        async def main() -> None:
            await client.create(
                decimal=1.1,
                even=1,
                name="string",
                shape="SQUARE",
            )


        asyncio.run(main())
        """
        _response = await self._client_wrapper.httpx_client.request(
            "create",
            method="POST",
            json={
                "decimal": decimal,
                "even": even,
                "name": name,
                "shape": shape,
            },
            request_options=request_options,
            omit=OMIT,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    Type, parse_obj_as(type_=Type, object_=_response.json())
                )  # type: ignore
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    async def get(
        self,
        *,
        decimal: float = 1.1,
        even: int = 42,
        name: str = "fern",
        request_options: typing.Optional[RequestOptions] = None,
    ) -> Type:
        """
        Parameters
        ----------
        decimal : float

        even : int

        name : str

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        Type

        Examples
        --------
        import asyncio

        from seed import AsyncSeedValidation

        client = AsyncSeedValidation(
            base_url="https://yourhost.com/path/to/api",
        )


        async def main() -> None:
            await client.get(
                decimal=1.1,
                even=1,
                name="string",
            )


        asyncio.run(main())
        """
        _response = await self._client_wrapper.httpx_client.request(
            method="GET",
            params={
                "decimal": decimal,
                "even": even,
                "name": name,
            },
            request_options=request_options,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    Type, parse_obj_as(type_=Type, object_=_response.json())
                )  # type: ignore
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)
