using System.Net.Http;
using System.Text.Json;
using System.Threading;
using SeedApi.Core;

#nullable enable

namespace SeedApi;

public partial class UserClient
{
    private RawClient _client;

    internal UserClient(RawClient client)
    {
        _client = client;
    }

    /// <example>
    /// <code>
    /// await client.User.CreateUserAsync(
    ///     new CreateUserRequest
    ///     {
    ///         Username = "string",
    ///         Email = "string",
    ///         Age = 1,
    ///         Weight = 1.1f,
    ///     }
    /// );
    /// </code>
    /// </example>
    public async Task<CreateUserResponse> CreateUserAsync(
        CreateUserRequest request,
        RequestOptions? options = null,
        CancellationToken cancellationToken = default
    )
    {
        var response = await _client.MakeRequestAsync(
            new RawClient.JsonApiRequest
            {
                BaseUrl = _client.Options.BaseUrl,
                Method = HttpMethod.Post,
                Path = "/users",
                Body = request,
                Options = options,
            },
            cancellationToken
        );
        var responseBody = await response.Raw.Content.ReadAsStringAsync();
        if (response.StatusCode is >= 200 and < 400)
        {
            try
            {
                return JsonUtils.Deserialize<CreateUserResponse>(responseBody)!;
            }
            catch (JsonException e)
            {
                throw new SeedApiException("Failed to deserialize response", e);
            }
        }

        throw new SeedApiApiException(
            $"Error with status code {response.StatusCode}",
            response.StatusCode,
            responseBody
        );
    }

    /// <example>
    /// <code>
    /// await client.User.GetUserAsync(
    ///     new GetUserRequest
    ///     {
    ///         Username = "string",
    ///         Age = 1,
    ///         Weight = 1.1f,
    ///     }
    /// );
    /// </code>
    /// </example>
    public async Task<User> GetUserAsync(
        GetUserRequest request,
        RequestOptions? options = null,
        CancellationToken cancellationToken = default
    )
    {
        var _query = new Dictionary<string, object>();
        if (request.Username != null)
        {
            _query["username"] = request.Username;
        }
        if (request.Age != null)
        {
            _query["age"] = request.Age.ToString();
        }
        if (request.Weight != null)
        {
            _query["weight"] = request.Weight.ToString();
        }
        var response = await _client.MakeRequestAsync(
            new RawClient.JsonApiRequest
            {
                BaseUrl = _client.Options.BaseUrl,
                Method = HttpMethod.Get,
                Path = "/users",
                Query = _query,
                Options = options,
            },
            cancellationToken
        );
        var responseBody = await response.Raw.Content.ReadAsStringAsync();
        if (response.StatusCode is >= 200 and < 400)
        {
            try
            {
                return JsonUtils.Deserialize<User>(responseBody)!;
            }
            catch (JsonException e)
            {
                throw new SeedApiException("Failed to deserialize response", e);
            }
        }

        throw new SeedApiApiException(
            $"Error with status code {response.StatusCode}",
            response.StatusCode,
            responseBody
        );
    }
}
