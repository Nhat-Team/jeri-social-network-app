import {createSlice} from "@reduxjs/toolkit";

export const colorSchemeSlice = createSlice({
    name: "colorScheme",
    initialState: "light",
    reducers: {
        setColorScheme: (type: string, _action): string => {
            return type;
        }
    }
});

export const { setColorScheme } = colorSchemeSlice.actions;
export default colorSchemeSlice.reducer;