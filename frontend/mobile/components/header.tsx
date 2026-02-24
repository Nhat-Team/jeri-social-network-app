import {StyleSheet, Text, View} from "react-native";
import { useSelector, useDispatch } from "react-redux";
import type { RootState } from "@/redux/store";
import {useCallback} from "react";
import {Router, useRouter} from "expo-router";
import {activeSearch, deactiveSearch} from "@/redux/slices/searchSlice";

export default function HeaderComponent() {

    const router: Router = useRouter();
    const search = useSelector((state: RootState) => state.search )
    const dispatch = useDispatch();

    const handleSearchInputFocus = useCallback((isFocus: boolean): void => {
        if(isFocus) {
            router.push("/search");
            dispatch(activeSearch());   
        } else {
            router.back();
            dispatch(deactiveSearch());
        }
    }, [router, dispatch]);

    return (
        <View style={style.container}>
            {
                search ? (
                    <View>

                    </View>
                ) : (
                    <View>

                    </View>
                )
            }
        </View>
    )
}

const style: StyleSheet = StyleSheet.create({
    container: {
        backgroundColor: "blue",
        padding: 10,
    }
})