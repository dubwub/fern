# This file was auto-generated by Fern from our API Definition.

# type: ignore
# flake8: noqa
# fmt: off
# isort: skip_file

from __future__ import annotations

import typing

import pydantic
import typing_extensions

from ...v_2.problem.types.test_case_id import TestCaseId
from .test_case_grade import TestCaseGrade


class GradedTestCaseUpdate(pydantic.BaseModel):
    test_case_id: TestCaseId = pydantic.Field(alias="testCaseId")
    grade: TestCaseGrade

    class Validators:
        """
        Use this class to add validators to the Pydantic model.

            @GradedTestCaseUpdate.Validators.field("test_case_id")
            def validate_test_case_id(v: TestCaseId, values: GradedTestCaseUpdate.Partial) -> TestCaseId:
                ...

            @GradedTestCaseUpdate.Validators.field("grade")
            def validate_grade(v: TestCaseGrade, values: GradedTestCaseUpdate.Partial) -> TestCaseGrade:
                ...
        """

        _test_case_id_validators: typing.ClassVar[typing.List[GradedTestCaseUpdate.Validators.TestCaseIdValidator]] = []
        _grade_validators: typing.ClassVar[typing.List[GradedTestCaseUpdate.Validators.GradeValidator]] = []

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["test_case_id"]
        ) -> typing.Callable[
            [GradedTestCaseUpdate.Validators.TestCaseIdValidator], GradedTestCaseUpdate.Validators.TestCaseIdValidator
        ]:
            ...

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["grade"]
        ) -> typing.Callable[
            [GradedTestCaseUpdate.Validators.GradeValidator], GradedTestCaseUpdate.Validators.GradeValidator
        ]:
            ...

        @classmethod
        def field(cls, field_name: str) -> typing.Any:
            def decorator(validator: typing.Any) -> typing.Any:
                if field_name == "test_case_id":
                    cls._test_case_id_validators.append(validator)
                if field_name == "grade":
                    cls._grade_validators.append(validator)
                return validator

            return decorator

        class TestCaseIdValidator(typing_extensions.Protocol):
            def __call__(self, v: TestCaseId, *, values: GradedTestCaseUpdate.Partial) -> TestCaseId:
                ...

        class GradeValidator(typing_extensions.Protocol):
            def __call__(self, v: TestCaseGrade, *, values: GradedTestCaseUpdate.Partial) -> TestCaseGrade:
                ...

    @pydantic.validator("test_case_id")
    def _validate_test_case_id(cls, v: TestCaseId, values: TestCaseId) -> TestCaseId:
        for validator in GradedTestCaseUpdate.Validators._test_case_id_validators:
            v = validator(v, values=values)
        return v

    @pydantic.validator("grade")
    def _validate_grade(cls, v: TestCaseGrade, values: TestCaseGrade) -> TestCaseGrade:
        for validator in GradedTestCaseUpdate.Validators._grade_validators:
            v = validator(v, values=values)
        return v

    class Partial(typing.TypedDict):
        test_case_id: typing_extensions.NotRequired[TestCaseId]
        grade: typing_extensions.NotRequired[TestCaseGrade]

    def json(self, **kwargs: typing.Any) -> str:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().json(**kwargs_with_defaults)

    def dict(self, **kwargs: typing.Any) -> typing.Dict[str, typing.Any]:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().dict(**kwargs_with_defaults)

    class Config:
        frozen = True
        allow_population_by_field_name = True
