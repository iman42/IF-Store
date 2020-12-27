import { render, screen } from '@testing-library/react';
import UploadButton from './UploadButton';

test('bite me', () => {
    render(<UploadButton />);
    screen.debug();
})