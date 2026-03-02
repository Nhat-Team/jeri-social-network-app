import { useLanguage } from "@/hooks/useLanguage";
import { Router, useRouter } from "expo-router";
import CustomSafeAreaView from "../styles/CustomSafeAreaView";
import Ionicons from '@expo/vector-icons/Ionicons';
import CustomIcon from "../styles/CustomIcon";
import CustomText from "../styles/CustomText";
import { Pressable } from "react-native";

export default function ProfileHeaderComponent() {

    const language = useLanguage();
    const router: Router = useRouter();

    return (
        <CustomSafeAreaView styles={{
            display: "flex",
            flexDirection: "row",
            alignItems: "center"
        }}>
            <Pressable onPress={() => router.back()}>
                <CustomIcon icon={<Ionicons name="arrow-back-outline" size={30} />}
                    props={{
                        style: {
                            color: "white"
                        }
                    }}
                />
            </Pressable>

            <CustomText content={language.profile.account_and_security.tab_name} styles={{
                marginLeft: 10,
                fontSize: 20,
                color: "white"
            }}/>
        </CustomSafeAreaView>
    )
}