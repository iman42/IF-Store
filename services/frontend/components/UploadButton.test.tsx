import { fireEvent, render, screen } from "@testing-library/react";
import fetchMock from "jest-fetch-mock";
import React from "react";
import UploadButton from "./UploadButton";

const getFakeFile = (content: string, type: string, name: string): File => {
    const blob: any = new Blob([content], { type});
    blob["lastModifiedDate"] = "";
    blob["name"] =name;
    return blob as File;
};

test("should show file upload button", () => {
    render(<UploadButton />);
    expect(screen.queryByLabelText("Upload Comic")).toBeVisible();
});

test("should upload comic", () => {
    render(<UploadButton />);
    const element = screen.getByLabelText("Upload Comic");

    fireEvent.change(element, { target: { files: [getFakeFile("content", "text/html", "file.txt")] } });

    expect(fetchMock.mock.calls[0][0]).toEqual("HTTP://localhost:8080/comics");
    expect(fetchMock.mock.calls[0][1]?.method).toEqual("POST");
});