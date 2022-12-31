import { render, screen } from "@testing-library/react";
import React from "react";
import { SignInButtons } from "./SignInButtons";
test("login click asks for email", () => {
    render(<SignInButtons />);

    expect(screen.queryByText("Email")).not.toBeVisible();
    screen.getByText("Login").click();

    expect(screen.queryByText("Email")).toBeVisible();
});
