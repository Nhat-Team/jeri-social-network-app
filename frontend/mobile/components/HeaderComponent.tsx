import { useLanguage } from "@/hooks/useLanguage";
import FontAwesome5 from "@expo/vector-icons/FontAwesome5";
import Ionicons from "@expo/vector-icons/Ionicons";
import { Router, usePathname, useRouter } from "expo-router";
import { useState } from "react";
import CustomSafeAreaView from "./styles/CustomSafeAreaView";
import CustomTextInput from "./styles/CustomTextInput";
import CustomTouchableOpacity from "./styles/CustomTouchableOpacity";
import CustomText from "./styles/CustomText";

export default function HeaderComponent() {
  const language = useLanguage();

  const [inputSearch, setInputSearch] = useState("");
  const router: Router = useRouter();
  const pathName: string = usePathname();

  return (
    <CustomSafeAreaView
      styles={{
        padding: 10,
        display: "flex",
        flexDirection: "row",
        alignItems: "center",
      }}
    >
      {pathName === "/search" ? (
        <CustomSafeAreaView
          styles={{
            display: "flex",
            flexDirection: "row",
            alignItems: "center",
            padding: 0,
          }}
        >
          <CustomTouchableOpacity props={{
            onPress: () => {
              router.back();
            }
          }}>
            <Ionicons name="arrow-back" size={24} color="white" />
          </CustomTouchableOpacity>
          <CustomSafeAreaView
            styles={{
              display: "flex",
              flexDirection: "row",
              alignItems: "center",
              backgroundColor: "white",
              borderWidth: 1,
              borderColor: "black",
              padding: 5,
              marginLeft: 10,
            }}
          >
            <FontAwesome5 name="search" size={24} color="black" />
            <CustomTextInput
              styles={{
                borderRadius: 0,
                borderColor: "transparent",
                borderWidth: 0,
                marginLeft: 10,
                outlineStyle: "none",
              }}
              props={{
                value: inputSearch,
                onChangeText: setInputSearch,
                placeholder: language.header.input_search.placeholder,
                autoFocus: true,
              }}
            />
          </CustomSafeAreaView>
        </CustomSafeAreaView>
      ) : (
        <CustomTouchableOpacity
          styles={{
            display: "flex",
            flexDirection: "row",
            alignItems: "center",
            backgroundColor: "transparent",
            borderWidth: 0,
            borderColor: "transparent",
            borderRadius: 0,
          }}
          props={{
            onPress: () => {
              router.push("/search");
            },
          }}
        >
          <FontAwesome5 name="search" size={24} color="white" />
          <CustomText content={language.header.input_search.placeholder} styles={{
            marginLeft: 10,
            color: "white"
          }} />
        </CustomTouchableOpacity>
      )}
    </CustomSafeAreaView>
  );
}
