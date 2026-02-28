import {createSlice} from "@reduxjs/toolkit";

export const languageSlice = createSlice({
    name: "language",
    initialState: "english",
    reducers: {
        setLanguage: (state, _action) => {
            return _action.payload;
        }
    }
});

export const { setLanguage } = languageSlice.actions;
export default languageSlice.reducer;