# This file was auto-generated by Fern from our API Definition.

from __future__ import annotations
from .test_submission_state import TestSubmissionState
from ....core.pydantic_utilities import IS_PYDANTIC_V2
from .workspace_submission_state import WorkspaceSubmissionState
from ....core.pydantic_utilities import UniversalRootModel
import typing
import typing_extensions
import pydantic
from ....core.pydantic_utilities import update_forward_refs

T_Result = typing.TypeVar("T_Result")


class _Factory:
    def test(self, value: TestSubmissionState) -> SubmissionTypeState:
        if IS_PYDANTIC_V2:
            return SubmissionTypeState(
                root=_SubmissionTypeState.Test(
                    **value.dict(exclude_unset=True), type="test"
                )
            )
        else:
            return SubmissionTypeState(
                __root__=_SubmissionTypeState.Test(
                    **value.dict(exclude_unset=True), type="test"
                )
            )

    def workspace(self, value: WorkspaceSubmissionState) -> SubmissionTypeState:
        if IS_PYDANTIC_V2:
            return SubmissionTypeState(
                root=_SubmissionTypeState.Workspace(
                    **value.dict(exclude_unset=True), type="workspace"
                )
            )
        else:
            return SubmissionTypeState(
                __root__=_SubmissionTypeState.Workspace(
                    **value.dict(exclude_unset=True), type="workspace"
                )
            )


class SubmissionTypeState(UniversalRootModel):
    factory: typing.ClassVar[_Factory] = _Factory()

    if IS_PYDANTIC_V2:
        root: typing_extensions.Annotated[
            typing.Union[_SubmissionTypeState.Test, _SubmissionTypeState.Workspace],
            pydantic.Field(discriminator="type"),
        ]

        def get_as_union(
            self,
        ) -> typing.Union[_SubmissionTypeState.Test, _SubmissionTypeState.Workspace]:
            return self.root
    else:
        __root__: typing_extensions.Annotated[
            typing.Union[_SubmissionTypeState.Test, _SubmissionTypeState.Workspace],
            pydantic.Field(discriminator="type"),
        ]

        def get_as_union(
            self,
        ) -> typing.Union[_SubmissionTypeState.Test, _SubmissionTypeState.Workspace]:
            return self.__root__

    def visit(
        self,
        test: typing.Callable[[TestSubmissionState], T_Result],
        workspace: typing.Callable[[WorkspaceSubmissionState], T_Result],
    ) -> T_Result:
        unioned_value = self.get_as_union()
        if unioned_value.type == "test":
            return test(
                TestSubmissionState(
                    **unioned_value.dict(exclude_unset=True, exclude={"type"})
                )
            )
        if unioned_value.type == "workspace":
            return workspace(
                WorkspaceSubmissionState(
                    **unioned_value.dict(exclude_unset=True, exclude={"type"})
                )
            )


class _SubmissionTypeState:
    class Test(TestSubmissionState):
        type: typing.Literal["test"] = "test"

    class Workspace(WorkspaceSubmissionState):
        type: typing.Literal["workspace"] = "workspace"


update_forward_refs(SubmissionTypeState)
