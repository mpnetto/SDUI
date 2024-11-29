package com.sacada.sdui.test

val samplePayload = """
{
    "topBar": {
        "type": "center",
        "attributes": {
            "title": "Now in Android",
            "scrollBehavior": "pinned"
        },
        "children": [
            {
                "type": "navigationIcon",
                "attributes": {
                    "iconName": "search",
                    "contentDescription": "Menu"
                },
                "action": {
                    "type": "event",
                    "destination": "goBack"
                }
            },
            {
                "type": "Action",
                "attributes": {
                    "iconName": "person",
                    "contentDescription": "Menu"
                },
                "action": {
                    "type": "event",
                    "destination": "goBack"
                }
            }
        ]
    },
    "bottomBar": {
        "type": "BottomBar",
        "children": [
            {
                "type": "Action",
                "attributes": {
                    "iconName": "home",
                    "contentDescription": "Home"
                },
                "action": {
                    "type": "navigate",
                    "destination": "homeScreen"
                }
            },
            {
                "type": "Action",
                "attributes": {
                    "iconName": "search",
                    "contentDescription": "Search"
                },
                "action": {
                    "type": "navigate",
                    "destination": "searchScreen"
                }
            },
            {
                "type": "FloatingActionButton",
                "attributes": {
                    "iconName": "arrow_forward",
                    "contentDescription": "Add"
                },
                "action": {
                    "type": "event",
                    "destination": "addItem"
                }
            }
        ]
    },
    "layout": {
        "type": "Column",
        "attributes": {
            "verticalArrangement": "SpaceBetween",
            "fillMaxSize": "true"
        },
        "children": [
            {
                "type": "Column",
                "attributes": {
                    "horizontalAlignment": "Start",
                    "padding": "24"
                },
                "children": [
                    {
                        "type": "Text",
                        "attributes": {
                            "content": "What are you interested in?",
                            "style": "titleLarge"
                        }
                    },
                     {
                        "type": "Text",
                        "attributes": {
                            "content": "Updates from interests you follow will appear here. Follow some things to get started.",
                            "style": "bodyMedium",
                            "padding": "12"
                        }
                    }
                    
                ]
            },
            {
                "type": "Row",
                "attributes": {
                    "horizontalArrangement": "SpaceBetween",
                    "padding": "16"
                },
                "children": [
                    {
                        "type": "Button",
                        "attributes": {
                            "text": "Confirmar"
                        },
                        "action": {
                            "type": "event",
                            "destination": "confirmAction"
                        }
                    },
                    {
                        "type": "Button",
                        "attributes": {
                            "text": "Cancelar"
                        },
                        "action": {
                            "type": "event",
                            "destination": "cancelAction"
                        }
                    }
                ]
            }
        ]
    }
}
"""
