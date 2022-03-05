import { render, screen } from "@testing-library/react";
import React from "react";
import Home from "../pages";

test("should show file upload button", () => {
    render(<Home />);
    expect(screen.queryByLabelText("Upload Comic")).toBeVisible();
});

test("should show hero", () => {
    render(<Home />);
    expect(screen.queryByText("IF Store")).toBeVisible();
});

test("comic buttons appear", () => {
    render(<Home />);
    expect(screen.queryByText("Uploaded Comics:")).toBeVisible();
});