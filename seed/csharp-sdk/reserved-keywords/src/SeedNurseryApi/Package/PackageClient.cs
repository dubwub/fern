using System.Net.Http;
using System.Threading.Tasks;
using SeedNurseryApi.Core;

#nullable enable

namespace SeedNurseryApi;

public partial class PackageClient
{
    private RawClient _client;

    internal PackageClient(RawClient client)
    {
        _client = client;
    }

    public async Task TestAsync(TestRequest request, RequestOptions? options = null)
    {
        var _query = new Dictionary<string, object>();
        _query["for"] = request.For;
        var response = await _client.MakeRequestAsync(
            new RawClient.JsonApiRequest
            {
                BaseUrl = _client.Options.BaseUrl,
                Method = HttpMethod.Post,
                Path = "",
                Query = _query,
                Options = options,
            }
        );
        if (response.StatusCode is >= 200 and < 400)
        {
            return;
        }
        var responseBody = await response.Raw.Content.ReadAsStringAsync();
        throw new SeedNurseryApiApiException(
            $"Error with status code {response.StatusCode}",
            response.StatusCode,
            responseBody
        );
    }
}
