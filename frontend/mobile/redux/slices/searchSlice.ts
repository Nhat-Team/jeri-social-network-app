import {createSlice} from "@reduxjs/toolkit";

export const searchSlice = createSlice({
    name: "search",
    initialState: false,
    reducers: {
        activeSearch: (_action) => {
            return true;
        },

        deactiveSearch: (_action) => {
            return false;
        }
    }
});

export const { activeSearch, deactiveSearch } = searchSlice.actions;
export default searchSlice.reducer;