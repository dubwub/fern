// Generated by Fern. Do not edit.

package api

import (
	core "github.com/fern-api/fern-go/internal/testdata/sdk/empty/fixtures/core"
)

type Service interface {
}

func NewClient(baseURL string, httpClient core.HTTPClient, opts ...core.ClientOption) (Service, error) {
	options := new(core.ClientOptions)
	for _, opt := range opts {
		opt(options)
	}
	return &client{}, nil
}

type client struct {
}
