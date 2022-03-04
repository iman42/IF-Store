import { render, screen, waitFor } from "@testing-library/react";
import React from "react";
import { UploadedComics } from "./UploadedComics";

const getFakeFile = (content: string, type: string, name: string): File => {
    const blob: any = new Blob([content], { type });
    blob["lastModifiedDate"] = "";
    blob["name"] = name;
    return blob as File;
};


describe( "given: comic A and comic B are uploaded", () => {
    beforeEach(() => {
        fetchMock.mockResponseOnce(JSON.stringify(
            [
                {id: "ComicA-ID", title: "ComicA"},
                {id: "ComicB-ID", title: "ComicB"}
            ]
        ));
    }); 

    test("should show comic titles", () => {
        render(<UploadedComics />);
    
        waitFor(() =>  expect(screen.getByText("ComicA, ComicB")).toBeVisible());
    });

});