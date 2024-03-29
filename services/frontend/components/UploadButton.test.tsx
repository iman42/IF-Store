import { fireEvent, render, screen } from "@testing-library/react";
import fetchMock from "jest-fetch-mock";
import React from "react";
import UploadButton from "./UploadButton";

const getFakeFile = (content: string, type: string, name: string): File => {
    // eslint-disable-next-line @typescript-eslint/no-explicit-any
    const blob: any = new Blob([content], { type });
    blob["lastModifiedDate"] = "";
    blob["name"] = name;
    return blob as File;
};

test("can't upload if not PDF", () => {
    window.alert = jest.fn();
    render(<UploadButton />);
    const form = screen.getByLabelText("Upload Comic");

    fireEvent.change(form, {
        target: { files: [getFakeFile("content", "text/html", "abcde.txt")] },
    });
    expect(fetchMock.mock.calls).toEqual([]);

});
test("should show file upload button", () => {
    render(<UploadButton />);
    expect(screen.queryByLabelText("Upload Comic")).toBeVisible();
});

test("should upload comic", () => {
    render(<UploadButton />);
    const form = screen.getByLabelText("Upload Comic");

    fireEvent.change(form, {
        target: { files: [getFakeFile("content", "text/html", "abcde.pdf")] },
    });

    expect(fetchMock.mock.calls[0][0]).toEqual("http://localhost:8080/comics");
    expect(fetchMock.mock.calls[0][1]?.method).toEqual("POST");
    expect(fetchMock.mock.calls[0][1]?.body?.toString()).toEqual("[object FormData]");
});

test("after uplaoding, should refresh page", () => {
    render(<UploadButton />);
    const form = screen.getByLabelText("Upload Comic");

    fireEvent.change(form, {
        target: { files: [getFakeFile("content", "text/html", "abcde.pdf")] },
    });

    expect(window.location.reload).toHaveBeenCalled();
});


