import { fireEvent, render, screen } from "@testing-library/react";
import fetchMock from "jest-fetch-mock";
import React from "react";
import UploadButton from "./UploadButton";

test("should show file upload button", () => {
    render(<UploadButton />);
    expect(screen.queryByLabelText("Upload Comic")).toBeVisible();
});

test("should upload comic", () => {
    render(<UploadButton />);
    const element = screen.getByLabelText("Upload Comic");
    fireEvent.change(element, {target: {files: [new File(["content"], "name")]}});
    console.log(fetchMock.mock.calls);
});