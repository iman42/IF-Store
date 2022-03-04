import {render, screen, waitFor} from "@testing-library/react";
import React from "react";
import {UploadedComics} from "./UploadedComics";

describe("given: comic A and comic B are uploaded", () => {
    beforeEach(() => {
        fetchMock.mockResponseOnce(JSON.stringify(
            [
                {id: "ComicA-ID", title: "ComicA"},
                {id: "ComicB-ID", title: "ComicB"}
            ]
        ));
    });
    afterEach(() => {
        fetchMock.resetMocks();
    });

    test("should show comic titles", async () => {
        render(<UploadedComics />);

        await waitFor(() => {
            expect(screen.getByText("ComicA")).toBeVisible();
            expect(screen.getByText("ComicB")).toBeVisible();
        });
    });

    test("should make the right request", async () => {
        render(<UploadedComics />);

        await waitFor(() => {
            expect(fetchMock.mock.calls).toHaveLength(1);
            expect(fetchMock.mock.calls[0]).toEqual(["http://localhost:8080/comics"]);
        });
    });
});
