// This file was auto-generated by Fern from our API Definition.

package api

import (
	json "encoding/json"
	fmt "fmt"
	core "github.com/fern-api/fern-go/internal/testdata/sdk/error/fixtures/core"
)

type NotImplementedError struct {
	*core.APIError
	Body string
}

func (n *NotImplementedError) UnmarshalJSON(data []byte) error {
	var body string
	if err := json.Unmarshal(data, &body); err != nil {
		return err
	}
	n.StatusCode = 501
	n.Body = body
	return nil
}

func (n *NotImplementedError) MarshalJSON() ([]byte, error) {
	return json.Marshal(n.Body)
}

func (n *NotImplementedError) Unwrap() error {
	return n.APIError
}

type OptionalStringError struct {
	*core.APIError
	Body *string
}

func (o *OptionalStringError) UnmarshalJSON(data []byte) error {
	if len(data) == 0 {
		o.StatusCode = 500
		return nil
	}
	var body *string
	if err := json.Unmarshal(data, &body); err != nil {
		return err
	}
	o.StatusCode = 500
	o.Body = body
	return nil
}

func (o *OptionalStringError) MarshalJSON() ([]byte, error) {
	if o.Body == nil {
		return nil, nil
	}
	return json.Marshal(o.Body)
}

func (o *OptionalStringError) Unwrap() error {
	return o.APIError
}

type TeapotError struct {
	*core.APIError
	Body []string
}

func (t *TeapotError) UnmarshalJSON(data []byte) error {
	var body []string
	if err := json.Unmarshal(data, &body); err != nil {
		return err
	}
	t.StatusCode = 418
	t.Body = body
	return nil
}

func (t *TeapotError) MarshalJSON() ([]byte, error) {
	return json.Marshal(t.Body)
}

func (t *TeapotError) Unwrap() error {
	return t.APIError
}

type UntypedError struct {
	*core.APIError
}

func (u *UntypedError) UnmarshalJSON(data []byte) error {
	u.StatusCode = 400
	return nil
}

func (u *UntypedError) MarshalJSON() ([]byte, error) {
	return nil, nil
}

type UpgradeError struct {
	*core.APIError
	Body string
}

func (u *UpgradeError) UnmarshalJSON(data []byte) error {
	var body string
	if err := json.Unmarshal(data, &body); err != nil {
		return err
	}
	if body != "upgrade" {
		return fmt.Errorf("expected literal %q, but found %q", "upgrade", body)
	}
	u.StatusCode = 426
	u.Body = body
	return nil
}

func (u *UpgradeError) MarshalJSON() ([]byte, error) {
	return json.Marshal("upgrade")
}

func (u *UpgradeError) Unwrap() error {
	return u.APIError
}

type UserNotFoundError struct {
	*core.APIError
	Body *UserNotFoundErrorBody
}

func (u *UserNotFoundError) UnmarshalJSON(data []byte) error {
	var body *UserNotFoundErrorBody
	if err := json.Unmarshal(data, &body); err != nil {
		return err
	}
	u.StatusCode = 404
	u.Body = body
	return nil
}

func (u *UserNotFoundError) MarshalJSON() ([]byte, error) {
	return json.Marshal(u.Body)
}

func (u *UserNotFoundError) Unwrap() error {
	return u.APIError
}
