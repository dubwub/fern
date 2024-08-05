# This file was auto-generated by Fern from our API Definition.

import typing
from ..core.client_wrapper import SyncClientWrapper
from ..core.request_options import RequestOptions
from .types.stream_response import StreamResponse
from .types.regular_response import RegularResponse
from ..core.pydantic_utilities import parse_obj_as
import json
from json.decoder import JSONDecodeError
from ..core.api_error import ApiError
from ..core.client_wrapper import AsyncClientWrapper

# this is used as the default value for optional parameters
OMIT = typing.cast(typing.Any, ...)


class DummyClient:
    def __init__(self, *, client_wrapper: SyncClientWrapper):
        self._client_wrapper = client_wrapper

    @typing.overload
    def generate(
        self,
        *,
        stream: typing.Literal[True],
        num_events: int,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> typing.Iterator[StreamResponse]:
        """
        Parameters
        ----------
        stream : typing.Literal[True]

        num_events : int

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.


        Examples
        --------
        from seed import SeedStreaming

        client = SeedStreaming(
            base_url="https://yourhost.com/path/to/api",
        )
        response = client.dummy.generate(
            stream=False,
            num_events=5,
        )
        for chunk in response:
            yield chunk
        """
        ...

    @typing.overload
    def generate(
        self,
        *,
        stream: typing.Literal[False],
        num_events: int,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> RegularResponse:
        """
        Parameters
        ----------
        stream : typing.Literal[False]

        num_events : int

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.


        Examples
        --------
        from seed import SeedStreaming

        client = SeedStreaming(
            base_url="https://yourhost.com/path/to/api",
        )
        client.dummy.generate(
            stream=False,
            num_events=5,
        )
        """
        ...

    def generate(
        self,
        *,
        stream: bool,
        num_events: int,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> typing.Union[typing.Iterator[StreamResponse], RegularResponse]:
        """
        Parameters
        ----------
        stream : bool

        num_events : int

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        """
        _request_json = {
            "stream": stream,
            "num_events": num_events,
        }
        if stream:

            async def stream_generator():
                with self._client_wrapper.httpx_client.stream(
                    "generate",
                    method="POST",
                    json=_request_json,
                    request_options=request_options,
                    omit=OMIT,
                ) as _response:
                    try:
                        if 200 <= _response.status_code < 300:
                            for _text in _response.iter_lines():
                                try:
                                    if len(_text) == 0:
                                        continue
                                    yield typing.cast(
                                        StreamResponse,
                                        parse_obj_as(
                                            type_=StreamResponse,
                                            object_=json.loads(_text),
                                        ),
                                    )  # type: ignore
                                except:
                                    pass
                            return
                        _response.read()
                        _response_json = _response.json()
                    except JSONDecodeError:
                        raise ApiError(
                            status_code=_response.status_code, body=_response.text
                        )
                    raise ApiError(
                        status_code=_response.status_code, body=_response_json
                    )

            return stream_generator()
        else:
            _response = self._client_wrapper.httpx_client.request(
                "generate",
                method="POST",
                json=_request_json,
                request_options=request_options,
                omit=OMIT,
            )
            try:
                if 200 <= _response.status_code < 300:
                    return typing.cast(
                        RegularResponse,
                        parse_obj_as(type_=RegularResponse, object_=_response.json()),
                    )  # type: ignore
                _response_json = _response.json()
            except JSONDecodeError:
                raise ApiError(status_code=_response.status_code, body=_response.text)
            raise ApiError(status_code=_response.status_code, body=_response_json)


class AsyncDummyClient:
    def __init__(self, *, client_wrapper: AsyncClientWrapper):
        self._client_wrapper = client_wrapper

    @typing.overload
    async def generate(
        self,
        *,
        stream: typing.Literal[True],
        num_events: int,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> typing.AsyncIterator[StreamResponse]:
        """
        Parameters
        ----------
        stream : typing.Literal[True]

        num_events : int

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.


        Examples
        --------
        import asyncio

        from seed import AsyncSeedStreaming

        client = AsyncSeedStreaming(
            base_url="https://yourhost.com/path/to/api",
        )


        async def main() -> None:
            response = await client.dummy.generate(
                stream=False,
                num_events=5,
            )
            async for chunk in response:
                yield chunk


        asyncio.run(main())
        """
        ...

    @typing.overload
    async def generate(
        self,
        *,
        stream: typing.Literal[False],
        num_events: int,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> RegularResponse:
        """
        Parameters
        ----------
        stream : typing.Literal[False]

        num_events : int

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.


        Examples
        --------
        import asyncio

        from seed import AsyncSeedStreaming

        client = AsyncSeedStreaming(
            base_url="https://yourhost.com/path/to/api",
        )


        async def main() -> None:
            await client.dummy.generate(
                stream=False,
                num_events=5,
            )


        asyncio.run(main())
        """
        ...

    async def generate(
        self,
        *,
        stream: bool,
        num_events: int,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> typing.Union[typing.AsyncIterator[StreamResponse], RegularResponse]:
        """
        Parameters
        ----------
        stream : bool

        num_events : int

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        """
        _request_json = {
            "stream": stream,
            "num_events": num_events,
        }
        if stream:

            async def stream_generator():
                async with self._client_wrapper.httpx_client.stream(
                    "generate",
                    method="POST",
                    json=_request_json,
                    request_options=request_options,
                    omit=OMIT,
                ) as _response:
                    try:
                        if 200 <= _response.status_code < 300:
                            async for _text in _response.aiter_lines():
                                try:
                                    if len(_text) == 0:
                                        continue
                                    yield typing.cast(
                                        StreamResponse,
                                        parse_obj_as(
                                            type_=StreamResponse,
                                            object_=json.loads(_text),
                                        ),
                                    )  # type: ignore
                                except:
                                    pass
                            return
                        await _response.aread()
                        _response_json = _response.json()
                    except JSONDecodeError:
                        raise ApiError(
                            status_code=_response.status_code, body=_response.text
                        )
                    raise ApiError(
                        status_code=_response.status_code, body=_response_json
                    )

            return stream_generator()
        else:
            _response = await self._client_wrapper.httpx_client.request(
                "generate",
                method="POST",
                json=_request_json,
                request_options=request_options,
                omit=OMIT,
            )
            try:
                if 200 <= _response.status_code < 300:
                    return typing.cast(
                        RegularResponse,
                        parse_obj_as(type_=RegularResponse, object_=_response.json()),
                    )  # type: ignore
                _response_json = _response.json()
            except JSONDecodeError:
                raise ApiError(status_code=_response.status_code, body=_response.text)
            raise ApiError(status_code=_response.status_code, body=_response_json)
