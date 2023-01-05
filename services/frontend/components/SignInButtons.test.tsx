import { render, screen } from "@testing-library/react";
import { SignInButtons } from "./SignInButtons";
test("page contains login button and email field", () => {
    render(<SignInButtons />);

    expect(screen.queryByText("Login")).toBeVisible();
    expect(screen.queryByText("Email")).toBeVisible();
});
